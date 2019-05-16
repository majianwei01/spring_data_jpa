package com.majianwei.controller;

import com.majianwei.common.JsonResult;
import com.majianwei.common.UIPage;
import com.majianwei.domain.Purchasebillitem;
import com.majianwei.domain.purchasebillitemvo.PurchaseBillItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.majianwei.query.PurchasebillitemQuery;
import com.majianwei.service.IPurchasebillitemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/purchasebillitem")
public class PurchasebillitemController extends BaseController {

    @Autowired
    private IPurchasebillitemService purchasebillitemService;

    @RequestMapping("/index")
    //   /WEB-INF/views/emp/purchasebillitem.jsp 浏览器真实访问路径
    public String index() {
        return "purchasebillitem/purchasebillitem";
    }


    @RequestMapping("/findItems")
    @ResponseBody
    public List<PurchaseBillItemVO> getItems(PurchasebillitemQuery query){
       return purchasebillitemService.findItems(query);
    }
    @RequestMapping("/findCharts")
    @ResponseBody
    public List<Map> findCharts(PurchasebillitemQuery query){
        return purchasebillitemService.findCharts(query);
    }

}