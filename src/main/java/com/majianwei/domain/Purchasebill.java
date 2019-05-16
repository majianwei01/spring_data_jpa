package com.majianwei.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import sun.nio.cs.FastCharsetProvider;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.crypto.Data;

/**
 * (Purchasebill)实体类
 *
 * @author makejava
 * @since 2019-02-15 16:39:53
 */
@Entity
@Table(name = "purchasebill")
public class Purchasebill extends BaseDomain {
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;//供应商,不能为空

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auditor_id")
    private Employee auditor;//审核员,不为空

    @ManyToOne(fetch = FetchType.LAZY,optional =false)
    @JoinColumn(name = "inputUser_id")
    private Employee inputUser;//录入员,不为空

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "buyer_id")
    private Employee buyer;//采购员

    //双向一对多，一方放弃维护交由多方bill字段来维护
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bill",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Purchasebillitem> list=new ArrayList<>();

    private Date vdate;//交易时间

    private BigDecimal totalamount;//总价格

    private BigDecimal totalnum;//总数量

    private Date inputtime=new Date();//录入时间,当前系统时间

    private Date auditortime;//审核时间

    private Integer status = 0;//状态,默认为待审

    public List<Purchasebillitem> getList() {
        return list;
    }

    public void setList(List<Purchasebillitem> list) {
        this.list = list;
    }

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

    public Employee getBuyer() {
        return buyer;
    }

    public void setBuyer(Employee buyer) {
        this.buyer = buyer;
    }



    
    //后台传入时间数据到前台展示要加这个注解
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM+8")
    public Date getVdate() {
        return vdate;
    }

    //前台传入时间数据到后台
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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


}