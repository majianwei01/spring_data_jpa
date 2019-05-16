package com.majianwei.query;

import com.github.wenhao.jpa.Specifications;
import com.majianwei.domain.Systemdictionarytype;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class SystemdictionarytypeQuery extends CommonQuery {
    private String name;

    //覆写父类的spec方法
    @Override
    public Specification createSpec() {
        Specification<Systemdictionarytype> spec = Specifications.<Systemdictionarytype>and()
                .like(StringUtils.isNotBlank(name),"name", "%"+name+"%")
                .build();
        return spec;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "$tableInfo.nameQuery{" +
                "name='" + name + '\'' +
                '}';
    }

}