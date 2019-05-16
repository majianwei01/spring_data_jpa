package com.majianwei.controller;

import com.majianwei.common.JsonResult;
import com.majianwei.common.UIPage;
import com.majianwei.common.UserContext;
import com.majianwei.domain.Purchasebill;
import com.majianwei.domain.Purchasebillitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.majianwei.query.PurchasebillQuery;
import com.majianwei.service.IPurchasebillService;

import java.util.List;


@Controller
@RequestMapping("/purchasebill")
public class PurchasebillController extends BaseController {

    @Autowired
    private IPurchasebillService purchasebillService;

    @RequestMapping("/index")
    //   /WEB-INF/views/emp/purchasebill.jsp 浏览器真实访问路径
    public String index() {
        return "/purchasebill/purchasebill";
    }

    //查询全部,返回页面上以json格式数据展示
    @RequestMapping("/page")
    @ResponseBody
    public List<Purchasebill> showData(){
        List<Purchasebill> purchasebill = purchasebillService.queryAll();
        return  purchasebill;
    }

    //分页查询
    @RequestMapping("/page2")
    @ResponseBody
    public UIPage page2(PurchasebillQuery query){
//        Page<Purchasebill> page = purchasebillService.findPageByQuery(query);
//        UIPage uiPage = new UIPage(page);
        System.out.println(purchasebillService);
        Page pageByQuery = purchasebillService.findPageByQuery(query);
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
            purchasebillService.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setSuccess(false);
            //jsonResult.setMsg("删除失败");
            jsonResult.setMsg(e.getMessage());
        }
        return jsonResult;
    }
    public JsonResult saveOrUpdate(Purchasebill purchasebill){
        JsonResult jsonResult = new JsonResult();
        try {
          //  purchasebill.setInputUser(UserContext.getUser());
            purchasebillService.save(purchasebill);
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
    public JsonResult save(Purchasebill purchasebill){
        JsonResult jsonResult = saveOrUpdate(purchasebill);
        return jsonResult;
    }
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(Purchasebill purchasebill){
        JsonResult jsonResult = saveOrUpdate(purchasebill);
        return jsonResult;
    }


//    /**
//     * 前台访问这个Controller的任何一个方法，都会先调用它
//     */
//    @ModelAttribute("editPurchasebill")
//    public Purchasebill beforeEdit(Long id,String _cmd){
//        //只有修改操作
//        if(id!=null && "update".equals(_cmd)){
//            System.out.println("我要操作了！！！");
//            //从数据库中拿到这个对象
//            Purchasebill purchasebill = purchasebillService.findOne(id);
//            //解决n-to-n的问题:把会传过来的关联对象设置为null
//            purchasebill.setSupplier(null);
//            purchasebill.setBuyer(null);
//            purchasebill.getItems().clear();
//            return purchasebill;
//        }
//        return null;
//    }

//    @RequestMapping("/checkName")
//    @ResponseBody
//    public boolean checkName(String username,Long id){
//        if(id!=null){
//            //代表是修改
//            //1.根据id到数据库中查询员工
//            Purchasebill dbEmp = purchasebillService.queryOne(id);
//            //2.如果名称(数据库的员工名称与传过来的)相等,就直接返回true
//            if(dbEmp.getUsername().equals(username)){
//                return true;
//            }
//        }
//        return purchasebillService.checkName(username);
//    }




}