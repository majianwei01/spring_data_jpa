package com.majianwei.query;

import com.github.wenhao.jpa.Specifications;
import com.majianwei.domain.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeQuery extends CommonQuery {
    private String username;
    private String email;
    private Integer age;
    //连了多对一之后添加部门支持
    private Long departmentId;
    //覆写父类的spec方法
    @Override
    public Specification createSpec() {
        Specification<Employee> spec = Specifications.<Employee>and()
                .like(StringUtils.isNotBlank(username),"username", "%"+username+"%")
                .like(StringUtils.isNotBlank(email), "email","%"+email+"%")
                .gt(age!=null, "age",age)//age是大于小于的模糊查询
                .build();
        return spec;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeQuery{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }

}
