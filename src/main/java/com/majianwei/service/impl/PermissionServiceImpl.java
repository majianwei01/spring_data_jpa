package com.majianwei.service.impl;

import com.majianwei.domain.Permission;
import com.majianwei.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IPermissionService;


@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission,Long> implements IPermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

}