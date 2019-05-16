package com.majianwei.service.impl;

import com.majianwei.domain.Productstock;
import com.majianwei.repository.ProductstockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IProductstockService;


@Service
public class ProductstockServiceImpl extends BaseServiceImpl<Productstock,Long> implements IProductstockService {
    @Autowired
    private ProductstockRepository productstockRepository;

}