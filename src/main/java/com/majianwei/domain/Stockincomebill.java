package com.majianwei.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * (Stockincomebill)实体类
 *
 * @author makejava
 * @since 2019-02-19 19:01:03
 */
@Entity
@Table(name = "stockincomebill")
public class Stockincomebill extends BaseDomain {

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;//供应商,不能为空

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditor_id")
    private Employee auditor;//审核员

    @ManyToOne(fetch = FetchType.LAZY,optional =false)
    @JoinColumn(name = "inputUser_id")
    private Employee inputUser;//录入员,不为空

    @ManyToOne(fetch = FetchType.LAZY,optional =false)
    @JoinColumn(name = "keeper_id")
    private Employee keeper;//库管员，非空

    @ManyToOne(fetch = FetchType.LAZY,optional =false)
    @JoinColumn(name = "depot_id")
    private Depot depot;//仓库，非空

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bill",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Stockincomebillitem> items=new ArrayList<>();

    private Date vdate;
    
    private BigDecimal totalamount;
    
    private BigDecimal totalnum;
    
    private Date inputtime;
    
    private Date auditortime;
    
    private Integer status;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Employee getAuditor() {
        return auditor;
    }

    public void setAuditor(Employee auditor) {
        this.auditor = auditor;
    }

    public Employee getInputUser() {
        return inputUser;
    }

    public void setInputUser(Employee inputUser) {
        this.inputUser = inputUser;
    }

    public Employee getKeeper() {
        return keeper;
    }

    public void setKeeper(Employee keeper) {
        this.keeper = keeper;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Date getVdate() {
        return vdate;
    }

    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

    public BigDecimal getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(BigDecimal totalnum) {
        this.totalnum = totalnum;
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    public Date getAuditortime() {
        return auditortime;
    }

    public void setAuditortime(Date auditortime) {
        this.auditortime = auditortime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Stockincomebillitem> getItems() {
        return items;
    }

    public void setItems(List<Stockincomebillitem> items) {
        this.items = items;
    }
}