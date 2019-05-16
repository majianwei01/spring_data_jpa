package com.majianwei.service.impl;

import com.majianwei.domain.Employee;
import com.majianwei.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IEmployeeService;

import java.util.List;

@Service
public class EmpolyeeServiceImp extends BaseServiceImpl<Employee,Long> implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

    @Override
    public List<Employee> findBuyersByDept() {
        return employeeRepository.findBuyersByDept("采购部");
    }


}
