package com.majianwei.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 1.规范子类的代码 2.公共代码抽取
 * JPA中如果要创建domain的父类，必需加上 @MappedSuperclass
 */
//父类要加这个注解
@MappedSuperclass
public class BaseDomain {

    @Id
    @GeneratedValue
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
