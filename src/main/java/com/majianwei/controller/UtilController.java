package com.majianwei.controller;

import com.majianwei.common.UserContext;
import com.majianwei.domain.*;
import com.majianwei.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/util")
public class UtilController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ISystemdictionarydetailService systemdictionarydetailService;

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private ISupplierService supplierService;

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/depts")
    @ResponseBody
    public List<Department> departmentList(){
        List<Department> departmentList = departmentService.queryAll();
        return departmentList;
    }

    @RequestMapping("/brands")
    @ResponseBody
    public List<Systemdictionarydetail> brands(){
        return systemdictionarydetailService.getBrands();
    }

    @RequestMapping("/units")
    @ResponseBody
    public List<Systemdictionarydetail> units(){
        return systemdictionarydetailService.getUnits();
    }

    @RequestMapping("/menu")
    @ResponseBody
    public List<Menu> getMenu(Long id){
        Employee user = UserContext.getUser();
        System.out.println("============="+user);
        return menuService.findUserMenu(user.getId());
    }

    //拿到所有供应商
    @RequestMapping("/suppliers")
    @ResponseBody
    public List<Supplier> supplierList(){
        return supplierService.queryAll();
    }
    //拿到所有员工
    @RequestMapping("/employee")
    @ResponseBody
    public List<Employee> employeeList(){
        return employeeService.queryAll();
    }

    //拿到所有采购部的员工
    @RequestMapping("/buyers")
    @ResponseBody
    public List<Employee> buyersList(){
        return employeeService.findBuyersByDept();
    }

    @RequestMapping("/products")
    @ResponseBody
    public List<Product> productList(){
        return productService.queryAll();
    }

}
