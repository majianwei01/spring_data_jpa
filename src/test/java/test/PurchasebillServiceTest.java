package test;

import com.majianwei.common.JsonResult;
import com.majianwei.common.UIPage;
import com.majianwei.domain.*;
import com.majianwei.service.IStockincomebillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.majianwei.query.PurchasebillQuery;
import com.majianwei.service.IPurchasebillService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicContext.xml")
public class PurchasebillServiceTest {
    @Autowired
    private IPurchasebillService purchasebillService;

    @Autowired
    private IStockincomebillService stockincomebillService;

    @Test
    public void queryAll() throws Exception{
        purchasebillService.queryAll().forEach(e-> System.out.println(e));

    }
    // 级联保存：一次性保存1个入库订单，2个入库订单明细
    @Test
    public void save() throws Exception {
        Stockincomebill bill = new Stockincomebill();
        bill.setDepot(new Depot(1L));
        bill.setInputUser(new Employee(1L));
        bill.setKeeper(new Employee(2L));
        bill.setSupplier(new Supplier(2L));
        bill.setVdate(new Date());

        // 2个入库明细
        List<Stockincomebillitem> items = new ArrayList<Stockincomebillitem>();
        Stockincomebillitem billItem = new Stockincomebillitem();
        billItem.setDescs("备注1");
        billItem.setNum(new BigDecimal(1));
        billItem.setPrice(new BigDecimal(1));
        billItem.setProduct(new Product(1L));
        items.add(billItem);

        Stockincomebillitem billItem2 = new Stockincomebillitem();
        billItem2.setDescs("备注2");
        billItem2.setNum(new BigDecimal(2));
        billItem2.setPrice(new BigDecimal(2));
        billItem2.setProduct(new Product(2L));
        items.add(billItem2);

        BigDecimal totalAmount = new BigDecimal(0);// 总金额
        BigDecimal totalNum = new BigDecimal(0);// 总数量
        for (Stockincomebillitem item : items) {
            // 设置多方到一方的关系
            item.setBill(bill);
            // 计算小计
            item.setAmount(item.getPrice().multiply(item.getNum()));
            // 累加
            totalAmount = totalAmount.add(item.getAmount());
            totalNum = totalNum.add(item.getNum());
        }
        // 设置总金额,总数量
        bill.setTotalamount(totalAmount);
        bill.setTotalnum(totalNum);

        // 设置一方到多方的关系
        bill.setItems(items);

        // 级联保存
        stockincomebillService.save(bill);
    }

}