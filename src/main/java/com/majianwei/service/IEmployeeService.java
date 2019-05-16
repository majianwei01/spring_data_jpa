package com.majianwei.service;

import com.majianwei.domain.Employee;

import java.util.List;

public interface IEmployeeService extends IBaseService<Employee,Long> {

    //根据用户名获取员工对象
    Employee findByUsername(String username);

    //根据部门名称找到对应部门的员工
    List<Employee> findBuyersByDept();
}
