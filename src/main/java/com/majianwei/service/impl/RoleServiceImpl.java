package com.majianwei.service.impl;

import com.majianwei.domain.Role;
import com.majianwei.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IRoleService;


@Service
public class RoleServiceImpl extends BaseServiceImpl<Role,Long> implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

}