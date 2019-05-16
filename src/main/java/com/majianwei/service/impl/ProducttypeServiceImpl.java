package com.majianwei.service.impl;

import com.majianwei.domain.Producttype;
import com.majianwei.repository.ProducttypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IProducttypeService;


@Service
public class ProducttypeServiceImpl extends BaseServiceImpl<Producttype,Long> implements IProducttypeService {
    @Autowired
    private ProducttypeRepository producttypeRepository;

}