package com.majianwei.controller;

import com.majianwei.common.JsonResult;
import com.majianwei.common.UIPage;
import com.majianwei.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.majianwei.query.EmployeeQuery;
import com.majianwei.service.IEmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController extends BaseController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/index")
    //   /WEB-INF/views/emp/employee.jsp 浏览器真实访问路径
    public String index() {
        return "emp/employee";
    }

    //查询全部,返回页面上以json格式数据展示
    @RequestMapping("/page")
    @ResponseBody
    public List<Employee> showData(){
        List<Employee> employee = employeeService.queryAll();
        System.out.println("========================="+employee);
        return  employee;
    }

    //分页查询
    @RequestMapping("/page2")
    @ResponseBody
    public UIPage page2(EmployeeQuery query){
//        Page<Employee> page = employeeService.findPageByQuery(query);
//        UIPage uiPage = new UIPage(page);
        System.out.println(employeeService);
        Page pageByQuery = employeeService.findPageByQuery(query);
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
            employeeService.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            jsonResult.setSuccess(false);
            //jsonResult.setMsg("删除失败");
            jsonResult.setMsg(e.getMessage());
        }
        return jsonResult;
    }
    public JsonResult saveOrUpdate(Employee employee){
        JsonResult jsonResult = new JsonResult();
        try {
            employeeService.save(employee);
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
    public JsonResult save(Employee employee){
        JsonResult jsonResult = saveOrUpdate(employee);
        return jsonResult;
    }
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(Employee employee){
        JsonResult jsonResult = saveOrUpdate(employee);
        return jsonResult;
    }
    /**
     * 前台访问这个Controller的任何一个方法，都会先调用它
     */
    @ModelAttribute("editEmployee")
    public Employee beforeEdit(Long id,String _cmd){
        //只有修改操作
        if(id!=null && "update".equals(_cmd)){
            System.out.println("前台传入的_cmd与我后台的_cmd的参数一致");
            //从数据库中拿到这个对象
            Employee dbEmp = employeeService.queryOne(id);
            //解决n-to-n的问题:把会传过来的关联对象设置为null
            dbEmp.setDepartment(null);
            return dbEmp;
        }else {
            System.out.println("BBBBBBBBBBBBBBBBB");
        }
        return null;
    }

//    @RequestMapping("/checkName")
//    @ResponseBody
//    public boolean checkName(String username,Long id){
//        if(id!=null){
//            //代表是修改
//            //1.根据id到数据库中查询员工
//            Employee dbEmp = employeeService.queryOne(id);
//            //2.如果名称(数据库的员工名称与传过来的)相等,就直接返回true
//            if(dbEmp.getUsername().equals(username)){
//                return true;
//            }
//        }
//        return employeeService.checkName(username);
//    }




}
