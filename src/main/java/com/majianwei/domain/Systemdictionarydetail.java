package com.majianwei.domain;

import javax.persistence.*;

/**
 * (Systemdictionarydetail)实体类
 *
 * @author makejava
 * @since 2019-02-15 11:38:21
 */
@Entity
@Table(name = "systemdictionarydetail")
public class Systemdictionarydetail extends BaseDomain {



    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "types_id")
    private Systemdictionarytype types;

    public Systemdictionarytype getTypes() {
        return types;
    }

    public void setTypes(Systemdictionarytype types) {
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    


}