package com.majianwei.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * (Department)实体类
 *
 * @author makejava
 * @since 2019-02-19 13:35:42
 */
@Entity
@Table(name = "department")
public class Department extends BaseDomain {
   
                                             
                
    
    private String name;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}