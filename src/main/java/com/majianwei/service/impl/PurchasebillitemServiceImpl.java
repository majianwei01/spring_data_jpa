package com.majianwei.service.impl;

import com.majianwei.domain.Purchasebillitem;
import com.majianwei.domain.purchasebillitemvo.PurchaseBillItemVO;
import com.majianwei.query.PurchasebillitemQuery;
import com.majianwei.repository.PurchasebillitemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IPurchasebillitemService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PurchasebillitemServiceImpl extends BaseServiceImpl<Purchasebillitem,Long> implements IPurchasebillitemService {
    @Autowired
    private PurchasebillitemRepository purchasebillitemRepository;

    @Override
    public List<PurchaseBillItemVO> findItems(PurchasebillitemQuery query) {
        //准备一个装vo的容器
        List<PurchaseBillItemVO> vos=new ArrayList<>();
        //通过查询条件拿到所有明细
        List<Purchasebillitem> items = super.findByQuery(query);
        for (Purchasebillitem item:items){
            PurchaseBillItemVO vo = new PurchaseBillItemVO(item, query.getGroupBy());
            //将明细的数据添加到我们写的VO类里
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<Map> findCharts(PurchasebillitemQuery query) {
        //准备相应的数据
        List<Map> listMap = new ArrayList<>();

        //String groupBy = "o.bill.supplier.name";
        // String groupBy = "o.bill.buyer.username";
        //拿到分组的字符串
        String groupBy = query.getGroupByStr();
        //拿到where条件的字符串
        String whereJPQL = query.createWhereJPQL();
        System.out.println("whereJPQL:"+whereJPQL);
        //拿到where条件中?对应的参数
        List<Object> params = query.getParams();
        //准备一条查询的jpql
        String jpql = "select "+groupBy+",sum(o.amount) from Purchasebillitem o "+whereJPQL+" group by "+groupBy;
        //这里必需传数组(才有变成多个值接收)
        List<Object[]> list = super.findByJpql(jpql,params.toArray());
        //把List<Object[]> 变成  List<Map>
        for (Object[] objects : list) {
            Map map = new HashMap();
            map.put("name", objects[0]);
            map.put("y", objects[1]);
            listMap.add(map);
        }
        return listMap;

    }
}