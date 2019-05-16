package com.majianwei.domain;

import javax.naming.Name;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * (Stockincomebillitem)实体类
 *
 * @author makejava
 * @since 2019-02-19 19:00:37
 */
@Entity
@Table(name = "stockincomebillitem")//入库明细
public class Stockincomebillitem extends BaseDomain {

    private BigDecimal price;
    private BigDecimal num;
    private BigDecimal amount;
    private String descs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Stockincomebill bill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public Stockincomebill getBill() {
        return bill;
    }

    public void setBill(Stockincomebill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
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
    
    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }


}