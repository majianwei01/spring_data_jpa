package com.majianwei.query;

import com.github.wenhao.jpa.Specifications;
import com.majianwei.domain.Purchasebillitem;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchasebillitemQuery extends CommonQuery {
    private Date beginDate;//开始时间
    private Date endDate;//结束时间
    private Integer status;//状态
    private Integer groupBy=1;//通过这个字段来找到分组的字段，默认由供应商名字来分组


    //覆写父类的spec方法
    @Override
    public Specification createSpec() {
        Date tempDate=null;
        if (endDate!=null){
            tempDate= DateUtils.addDays(endDate, 1);
        }
        Specification<Purchasebillitem> spec = Specifications.<Purchasebillitem>and()
                .eq(status!=null, "bill.status",status)
                .ge(beginDate!=null, "bill.beginDate",beginDate)
                .lt(tempDate!=null, "bill.endDate",tempDate)
                .build();
        return spec;
    }
    //准备一个装参数的集合
    private List<Object> params = new ArrayList<>();
    /**
     * 返回条件的JPQL  where o.bill.vdate >=? and o.bill.vdate < ? and status = ?
     * @return
     */
    public String createWhereJPQL(){

        StringBuilder whereJpql = new StringBuilder();
        if(beginDate!=null){
            whereJpql.append(" and o.bill.vdate >=? ");
            params.add(beginDate);
        }
        if(endDate!=null){
            Date tempDate = DateUtils.addDays(endDate, 1);
            whereJpql.append(" and o.bill.vdate < ? ");
            params.add(tempDate);
        }
        if (status!=null){
            whereJpql.append(" and o.bill.status = ? ");
            params.add(status);
        }
        //replaceFirst:把第一个and替换成where
        return whereJpql.toString().replaceFirst("and", "where");
    }

    public Integer getGroupBy() {
        return groupBy;
    }

    public String getGroupByStr() {
        if(groupBy==1){
            return "o.bill.supplier.name";
        }else if(groupBy==2){
            return "o.bill.buyer.username";
        }else{
            return "MONTH(o.bill.vdate)";
        }
    }

    public Date getBeginDate() {
        return beginDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setGroupBy(Integer groupBy) {
        this.groupBy = groupBy;
    }

    public List<Object> getParams() {
        return params;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }
}