package com.majianwei.service;

import com.majianwei.domain.Systemdictionarydetail;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ISystemdictionarydetailService extends IBaseService<Systemdictionarydetail,Long>{

    //在产品细节接口类中定义两个方法
    List<Systemdictionarydetail> getBrands();
    List<Systemdictionarydetail> getUnits();


}