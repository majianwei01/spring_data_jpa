package com.majianwei.query;

import com.github.wenhao.jpa.Specifications;
import com.majianwei.domain.Purchasebill;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PurchasebillQuery extends CommonQuery {
    private Date beginDate;//开始时间
    private Date endDate;//结束时间
    private Integer status;//状态

    //覆写父类的spec方法
    @Override
    public Specification createSpec() {
        //临时时间，如果结束时间不为空，就在结束时间基础上加一天
        Date tempDate=null;
        if(endDate!=null){
            tempDate= DateUtils.addDays(endDate, 1);
        }
        //高级查询，ge(大于等于)，le（小于），lt（小于等于）
        Specification<Purchasebill> spec = Specifications.<Purchasebill>and()
                .ge(beginDate!=null,"vdate",beginDate)
                .lt(tempDate!=null,"vdate",tempDate)
                .eq(status!=null,"status",status)
                .build();
        return spec;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    //前台到后台时间格式的处理加上这个注解，否则会报400类型不匹配的错误
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

}