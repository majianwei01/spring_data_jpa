package com.majianwei.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2019-02-15 18:06:23
 */
@Entity
@Table(name = "menu")
public class Menu extends BaseDomain {
    private String name;//菜单名字
    private String url;//路径
    private String icon;//图标
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonIgnore//忽略json，避免功能重复，避免子菜单找父菜单，否则会死循环
    private Menu parent;


    /**
     * 配置一对多：必需通过父菜单展开子菜单(也需要一对多)
     *      让一方放弃关系维护：性能更好
     * 1.这个属性必需有(才可以通过父菜单去获取子菜单)
     * 2.这个属性不能交给JPA管理(交给JPA管理就没办法做权限的过滤)
     * @Transient:临时属性(JPA不去管理这个字段)
     * @return
     */
    //一对多的情况，JPA会自动拿到多方所有数据，如果多方中有不能访问的权限，就会出问题，所以不设置JPA的管理
    @Transient
    private List<Menu> children = new ArrayList<>();

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public String getText(){ //EasyUI的树需要一个text属性
        return name;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


}