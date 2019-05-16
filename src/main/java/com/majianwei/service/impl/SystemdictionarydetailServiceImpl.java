package com.majianwei.service.impl;

import com.majianwei.domain.Systemdictionarydetail;
import com.majianwei.domain.Systemdictionarytype;
import com.majianwei.repository.SystemdictionarydetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.ISystemdictionarydetailService;

import java.util.List;


@Service
public class SystemdictionarydetailServiceImpl extends BaseServiceImpl<Systemdictionarydetail,Long> implements ISystemdictionarydetailService {
    @Autowired
    private SystemdictionarydetailRepository systemdictionarydetailRepository;



    @Override
    public List<Systemdictionarydetail> getBrands() {
        return systemdictionarydetailRepository.findBySn(Systemdictionarytype.PRODUCTBRAND);
    }

    @Override
    public List<Systemdictionarydetail> getUnits() {
        return systemdictionarydetailRepository.findBySn(Systemdictionarytype.PRODUCTUNIT);
    }
}