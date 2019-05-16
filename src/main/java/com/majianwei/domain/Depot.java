package com.majianwei.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * (Depot)实体类
 *
 * @author makejava
 * @since 2019-02-19 19:17:40
 */
@Entity
@Table(name = "depot")
public class Depot extends BaseDomain {
    public Depot() {}
    public Depot(Long id) {
        this.id = id;
    }

    private String name;//仓库名称
    private BigDecimal maxcapacity;//最大容量
    private BigDecimal currentcapacity;//当前容量
    private BigDecimal totalamount;//总金额（参考）

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public BigDecimal getMaxcapacity() {
        return maxcapacity;
    }

    public void setMaxcapacity(BigDecimal maxcapacity) {
        this.maxcapacity = maxcapacity;
    }
    
    public BigDecimal getCurrentcapacity() {
        return currentcapacity;
    }

    public void setCurrentcapacity(BigDecimal currentcapacity) {
        this.currentcapacity = currentcapacity;
    }
    
    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

}