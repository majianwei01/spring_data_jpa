package com.majianwei.service.impl;

import com.majianwei.domain.Supplier;
import com.majianwei.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.ISupplierService;


@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier,Long> implements ISupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

}