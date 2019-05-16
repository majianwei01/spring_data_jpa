package com.majianwei.service.impl;

import com.majianwei.domain.Product;
import com.majianwei.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IProductService;


@Service
public class ProductServiceImpl extends BaseServiceImpl<Product,Long> implements IProductService {
    @Autowired
    private ProductRepository productRepository;

}