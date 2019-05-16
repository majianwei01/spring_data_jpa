package com.majianwei.domain;

import javax.persistence.*;

/**
 * (Producttype)实体类
 *
 * @author makejava
 * @since 2019-02-15 14:24:43
 */
@Entity
@Table(name = "producttype")
public class Producttype extends BaseDomain {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Producttype parent;

    private String name;
    
    private String descs;
    
    private Long parentId;

    public Producttype getParent() {
        return parent;
    }

    public void setParent(Producttype parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }
    
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

}