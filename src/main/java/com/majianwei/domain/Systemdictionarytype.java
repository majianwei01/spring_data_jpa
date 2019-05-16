package com.majianwei.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * (Systemdictionarytype)实体类
 *
 * @author makejava
 * @since 2019-02-15 11:38:37
 */
@Entity
@Table(name = "systemdictionarytype")
public class Systemdictionarytype extends BaseDomain {
    public static final String PRODUCTBRAND="productBrand";
    public static final String PRODUCTUNIT="productUnit";

    //编码为唯一，设置成禁止修改
    @Column(updatable = false)
    private String sn;
    
    private String name;

    
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}