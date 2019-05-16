package com.majianwei.controller;

import com.majianwei.common.JsonResult;
import com.majianwei.common.UIPage;
import com.majianwei.domain.Producttype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.majianwei.query.ProducttypeQuery;
import com.majianwei.service.IProducttypeService;

import java.util.List;


@Controller
@RequestMapping("/producttype")
public class ProducttypeController extends BaseController {

    @Autowired
    private IProducttypeService producttypeService;

    @RequestMapping("/index")
    //   /WEB-INF/views/emp/producttype.jsp 浏览器真实访问路径
    public String index() {
        return "producttype/producttype";
    }

    //查询全部,返回页面上以json格式数据展示
    @RequestMapping("/page")
    @ResponseBody
    public List<Producttype> showData(){
        List<Producttype> producttype = producttypeService.queryAll();
        System.out.println("========================="+producttype);
        return  producttype;
    }

    //分页查询
    @RequestMapping("/page2")
    @ResponseBody
    public UIPage page2(ProducttypeQuery query){
//        Page<Producttype> page = producttypeService.findPageByQuery(query);
//        UIPage uiPage = new UIPage(page);
        System.out.println(producttypeService);
        Page pageByQuery = producttypeService.findPageByQuery(query);
        //将查询出的数据封装到UIpage
        UIPage uiPage = new UIPage(pageByQuery);
        return uiPage;
    }

    //后台删除方法，前台删除返回的是success;true/fasle,所以后台返回的结果也应该是true/false
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(Long id){
        JsonResult jsonResult = new JsonResult();
        try {
            producttypeService.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setSuccess(false);
            //jsonResult.setMsg("删除失败");
            jsonResult.setMsg(e.getMessage());
        }
        return jsonResult;
    }
    public JsonResult saveOrUpdate(Producttype producttype){
        JsonResult jsonResult = new JsonResult();
        try {
            producttypeService.save(producttype);
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setSuccess(false);
            jsonResult.setMsg(e.getMessage());
        }
        return jsonResult;
    }
    //添加
    @RequestMapping("/save")
    @ResponseBody
    public JsonResult save(Producttype producttype){
        JsonResult jsonResult = saveOrUpdate(producttype);
        return jsonResult;
    }
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(Producttype producttype){
        JsonResult jsonResult = saveOrUpdate(producttype);
        return jsonResult;
    }

//    @RequestMapping("/checkName")
//    @ResponseBody
//    public boolean checkName(String username,Long id){
//        if(id!=null){
//            //代表是修改
//            //1.根据id到数据库中查询员工
//            Producttype dbEmp = producttypeService.queryOne(id);
//            //2.如果名称(数据库的员工名称与传过来的)相等,就直接返回true
//            if(dbEmp.getUsername().equals(username)){
//                return true;
//            }
//        }
//        return producttypeService.checkName(username);
//    }




}