package com.majianwei.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2019-02-15 14:23:49
 */
@Entity
@Table(name = "product")
public class Product extends BaseDomain {

    public Product() {}
    public Product(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "types_id")
    private Producttype types;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private Systemdictionarydetail unit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Systemdictionarydetail brand;

    public Systemdictionarydetail getUnit() {
        return unit;
    }

    public void setUnit(Systemdictionarydetail unit) {
        this.unit = unit;
    }

    public Systemdictionarydetail getBrand() {
        return brand;
    }

    public void setBrand(Systemdictionarydetail brand) {
        this.brand = brand;
    }

    public Producttype getTypes() {
        return types;
    }

    public void setTypes(Producttype types) {
        this.types = types;
    }

    private String name;//产品名称
    
    private String color;//产品颜色
    
    private String pic;//产品大图
    
    private String smallpic;//产品缩略图
    
    private BigDecimal costprice;//成本价
    
    private BigDecimal saleprice;//售价

    private Long unitId;
    
    private Long brandId;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    
    public String getSmallpic() {
        return smallpic;
    }

    public void setSmallpic(String smallpic) {
        this.smallpic = smallpic;
    }
    
    public BigDecimal getCostprice() {
        return costprice;
    }

    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
    }
    
    public BigDecimal getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(BigDecimal saleprice) {
        this.saleprice = saleprice;
    }
    

    
    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }
    
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}