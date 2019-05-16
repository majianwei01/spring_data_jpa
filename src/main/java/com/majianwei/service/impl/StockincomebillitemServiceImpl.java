package com.majianwei.service.impl;

import com.majianwei.domain.Stockincomebillitem;
import com.majianwei.repository.StockincomebillitemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IStockincomebillitemService;


@Service
public class StockincomebillitemServiceImpl extends BaseServiceImpl<Stockincomebillitem,Long> implements IStockincomebillitemService {
    @Autowired
    private StockincomebillitemRepository stockincomebillitemRepository;

}