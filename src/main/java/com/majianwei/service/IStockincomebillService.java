package com.majianwei.service;

import com.majianwei.domain.Stockincomebill;


public interface IStockincomebillService extends IBaseService<Stockincomebill,Long>{

    void auditData(Long billId);


}