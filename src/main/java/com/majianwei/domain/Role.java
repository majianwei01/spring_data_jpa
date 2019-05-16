package com.majianwei.domain;

import javax.naming.Name;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role extends BaseDomain {
    private String name;
    private String sn;

    //角色与权限多对多,单独生成一张外键关系表，"role_permission"
    @ManyToMany
    @JoinTable(name = "role_permission",
            joinColumns=@JoinColumn(name = "role_id")
            ,inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> permissions=new ArrayList<>();


    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", sn='" + sn + '\'' +
                ", id=" + id +
                '}';
    }
}
