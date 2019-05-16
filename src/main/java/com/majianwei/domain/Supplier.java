package com.majianwei.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * (Supplier)实体类
 *
 * @author makejava
 * @since 2019-02-15 16:44:45
 */
@Entity
@Table(name = "supplier")
public class Supplier extends BaseDomain {

    public Supplier() {}
    public Supplier(Long id) {
        this.id = id;
    }
   
                                             
                
    
    private String name;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}