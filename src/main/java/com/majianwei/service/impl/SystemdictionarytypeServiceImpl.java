package com.majianwei.service.impl;

import com.majianwei.domain.Systemdictionarytype;
import com.majianwei.repository.SystemdictionarytypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.ISystemdictionarytypeService;

import java.util.List;


@Service
public class SystemdictionarytypeServiceImpl extends BaseServiceImpl<Systemdictionarytype,Long> implements ISystemdictionarytypeService {
    @Autowired
    private SystemdictionarytypeRepository systemdictionarytypeRepository;



}