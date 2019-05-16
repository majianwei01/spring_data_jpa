package com.majianwei.service;

import com.majianwei.domain.Purchasebillitem;
import com.majianwei.domain.purchasebillitemvo.PurchaseBillItemVO;
import com.majianwei.query.PurchasebillitemQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;


public interface IPurchasebillitemService extends IBaseService<Purchasebillitem,Long>{

    //传入查询条件返回报表数据的集合
    List<PurchaseBillItemVO> findItems(PurchasebillitemQuery query);

    //返回报表(图表)中需要的数据
    List<Map> findCharts(PurchasebillitemQuery query);


}