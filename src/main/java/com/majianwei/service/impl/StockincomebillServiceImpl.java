package com.majianwei.service.impl;

import com.majianwei.common.UserContext;
import com.majianwei.domain.*;
import com.majianwei.repository.StockincomebillRepository;
import com.majianwei.service.IDepotService;
import com.majianwei.service.IProductService;
import com.majianwei.service.IProductstockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IStockincomebillService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Service
public class StockincomebillServiceImpl extends BaseServiceImpl<Stockincomebill,Long> implements IStockincomebillService {
    @Autowired
    private StockincomebillRepository stockincomebillRepository;

    @Autowired
    private IDepotService depotService;

    @Autowired
    private IProductstockService productstockService;

    @Override
    public void auditData(Long billId) {
        //通过单据id拿到单据
        Stockincomebill bill = stockincomebillRepository.findOne(billId);
        if (bill==null){
            throw new RuntimeException("该单据不存在");
        }
        if (bill.getStatus()==1){
            throw new RuntimeException("该单据已审核");
        }
        if (bill.getStatus()==0){
            throw new RuntimeException("该单据已作废");
        }
        //设置该单据状态
        bill.setStatus(1);
        //设置审核时间
        bill.setAuditortime(new Date());
        //设置审核人，当前登录用户就是审核人
        bill.setAuditor(UserContext.getUser());
        //保存
        stockincomebillRepository.save(bill);

        //拿到当前仓库
        Depot depot = bill.getDepot();
        //设置当前仓库的容量和金额
        depot.setCurrentcapacity(depot.getCurrentcapacity().add(bill.getTotalnum()));
        depot.setTotalamount(depot.getTotalamount().add(bill.getTotalnum()));
        depotService.save(depot);

        //拿到单据明细
        List<Stockincomebillitem> items = bill.getItems();
        //通过即时库存表中的产品跟仓库字段拿到即时所有数据
        String jpql="select s from productstock s where o.product=? and o.depot=?";
        //遍历单据明细拿到产品跟仓库
        for (Stockincomebillitem item:items){
            Product product = item.getProduct();
            //拿到审核完的即时数据
            List<Productstock> stocks = productstockService.findByJpql(jpql, product, depot);
            if(stocks.size()==0){
                //JavaBean可以优化下面代码
                //代表没有查询到数据，就是新添加一个库存数据
                Productstock ps = new Productstock();
                ps.setNum(item.getNum());
                ps.setPrice(item.getPrice());
                ps.setAmount(item.getAmount());
                ps.setIncomedate(new Date());
                ps.setProduct(product);
                ps.setDepot(depot);
                productstockService.save(ps);
            }else if(stocks.size()==1){
                //代表 数据库中有一条数所，要对这条数据进行累加
                //1.拿到这个数据
                Productstock ps = stocks.get(0);
                ps.setIncomedate(new Date()); //入库时间就是当前时间
                ps.setNum(ps.getNum().add(item.getNum())); //数量累加
                ps.setAmount(ps.getAmount().add(item.getAmount())); //金额累加
                //四舍五入，保留两位小数(解决除不尽报错问题)
                ps.setPrice(ps.getAmount().divide(ps.getNum(), 2, BigDecimal.ROUND_HALF_EVEN)); //计算(加权平均法)
                productstockService.save(ps);
            }else{
                throw new RuntimeException("系统出现问题，代号399,请联系管理员解决！");
            }
        }


    }
}