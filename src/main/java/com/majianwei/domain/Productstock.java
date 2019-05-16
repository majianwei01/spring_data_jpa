package com.majianwei.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * (Productstock)实体类
 *
 * @author makejava
 * @since 2019-02-19 18:57:31
 */
@Entity
@Table(name = "productstock")//即时库存
public class Productstock extends BaseDomain {

    private BigDecimal num;
    private BigDecimal amount;
    private BigDecimal price;
    private Date incomedate;//入库时间
    private Boolean warning;//库存过多警告
    private BigDecimal topnum=new BigDecimal(100);//最大库存量
    private BigDecimal bottomnum=new BigDecimal(50);//最小库存量

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY,optional =false)
    @JoinColumn(name = "depot_id")
    private Depot depot;//仓库，非空

    
    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public Date getIncomedate() {
        return incomedate;
    }

    public void setIncomedate(Date incomedate) {
        this.incomedate = incomedate;
    }
    
    public Boolean getWarning() {
        return warning;
    }

    public void setWarning(Boolean warning) {
        this.warning = warning;
    }
    
    public BigDecimal getTopnum() {
        return topnum;
    }

    public void setTopnum(BigDecimal topnum) {
        this.topnum = topnum;
    }
    
    public BigDecimal getBottomnum() {
        return bottomnum;
    }

    public void setBottomnum(BigDecimal bottomnum) {
        this.bottomnum = bottomnum;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }
}