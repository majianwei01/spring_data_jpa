package com.majianwei.service.impl;

import com.majianwei.domain.Depot;
import com.majianwei.repository.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IDepotService;


@Service
public class DepotServiceImpl extends BaseServiceImpl<Depot,Long> implements IDepotService {
    @Autowired
    private DepotRepository depotRepository;

}