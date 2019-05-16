package com.majianwei.service.impl;

import com.majianwei.domain.Department;
import com.majianwei.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IDepartmentService;


@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department,Long> implements IDepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

}