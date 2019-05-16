package com.majianwei.query;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

//父类，抽取的公共的共有的查询属性
public abstract class CommonQuery {
    public int currentPage=1;
    public int pageSize=10;
    private String orderType="DESC";//true为降序，false为升序

    private String orderFiled;//传入就排序，不传入就不排序

    //抽取一个spec规则查询方法，abstract规定只有该类的子类才能调用此方法,将创建spec的方法封装成一样，规范方法
    public abstract Specification createSpec();

    //创建Sort排序对象的方法，如果有传入就进行排序，
    // 传入的值如果等于成员变量中给定的默认值true就进行降序，不等于true就进行降序
    //没有传入就返回null，不进行排序
    public Sort creatSort(){
        if (orderFiled!=null){
            Sort.Direction type=orderType.equals("DESC")?Sort.Direction.DESC:Sort.Direction.ASC;
            System.out.println(type);
            return new Sort(type,orderFiled);
        }
        return null;
    };


    public int getCurrentPage() {
        return currentPage;
    }

    //前台传入当前页最小是从0开始，而后台操作是可以从0开始，所以单独一个方法，方便于后台的操作
    public int getJpapage(){
        return currentPage-1;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderFiled() {
        return orderFiled;
    }

    public void setOrderFiled(String orderFiled) {
        this.orderFiled = orderFiled;
    }

    @Override
    public String toString() {
        return "CommonQuery{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", orderType=" + orderType +
                ", orderFiled='" + orderFiled + '\'' +
                '}';
    }
    //兼容Easyui的分页
    public void setPage(int page) {
        this.currentPage = page;
    }
    public void setRows(int rows) {
        this.pageSize = rows;
    }
}
