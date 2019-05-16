package com.majianwei.repository;

import com.majianwei.domain.Systemdictionarydetail;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SystemdictionarydetailRepository extends BaseRepository<Systemdictionarydetail,Long>{

    //根据编号来查找产品细节
    @Query("select s from Systemdictionarydetail s where s.types.sn=?1")
    List<Systemdictionarydetail> findBySn(String sn);


}