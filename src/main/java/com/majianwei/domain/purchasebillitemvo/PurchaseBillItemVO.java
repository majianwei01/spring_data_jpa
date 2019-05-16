package com.majianwei.domain.purchasebillitemvo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.majianwei.domain.Purchasebillitem;
import org.apache.commons.collections.IterableMap;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class PurchaseBillItemVO {
    private Long id;//编号
    private String supplierName;//供应商名字
    private String buyerName;//采购员名字
    private String productName; //产品名称
    private String productTypeName; //产品分类
    private Date vdate; //交易时间
    private BigDecimal num; //采购数量
    private BigDecimal price; //价格
    private BigDecimal amount; //小计 = 价格*数量
    private Integer status;//状态，默认为待审状态

    private String groupField="";//分组字段


    //提供一个有参构造
    public PurchaseBillItemVO(Purchasebillitem item,Integer groupBy) {
        this.id=item.getId();
        this.supplierName=item.getBill().getSupplier().getName();
        this.buyerName=item.getBill().getBuyer().getUsername();
        this.productName=item.getProduct().getName();
        this.productTypeName=item.getProduct().getTypes().getName();
        this.vdate=item.getBill().getVdate();
        this.num=item.getNum();
        this.amount=item.getAmount();
        this.price=item.getPrice();
        this.status=item.getBill().getStatus();
        if (groupBy == 1){
            this.groupField=supplierName;
        }else if(groupBy == 2){
            this.groupField=buyerName;
        }else {
            this.groupField= (DateUtils.toCalendar(vdate).get(Calendar.MONTH)+1)+"月";
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getVdate() {
        return vdate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }
}
