package com.majianwei.query;

import com.github.wenhao.jpa.Specifications;
import com.majianwei.domain.Department;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class DepartmentQuery extends CommonQuery {
    private String name;

    //覆写父类的spec方法
    @Override
    public Specification createSpec() {
        Specification<Department> spec = Specifications.<Department>and()
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