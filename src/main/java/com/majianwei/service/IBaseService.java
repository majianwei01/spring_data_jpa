package com.majianwei.service;

import org.springframework.data.domain.Page;
import com.majianwei.query.CommonQuery;

import java.io.Serializable;
import java.util.List;

//Jpa规定主键必须实现Serializable接口
public interface IBaseService<T,ID extends Serializable> {
    //添加和修改
    void save(T t);
    //删除
    void delete(ID id);
    //查询一条数据
    T queryOne(ID id);
    //查询全部数据
    List<T> queryAll();

    //根据公共类对象拿到分页对象(分页)
    Page findPageByQuery(CommonQuery commonQuery);

    //根据公共类对象拿到对应的所有数据(不分页)
    List<T> findByQuery(CommonQuery commonQuery);

    //根据jpql与对应的参数拿到数据
    // ...可变参数，传入的参数可以为多个
    List findByJpql(String jpql,Object... values);


}
