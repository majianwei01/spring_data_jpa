package com.majianwei.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import com.majianwei.query.CommonQuery;

import java.io.Serializable;
import java.util.List;

//自定义一个接口，该接口继承了JpaRepository，并且该接口的实现类继承了SimpleJpaRepository
//注解：该接口不会被实例化---？？？
@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T>{
    //根据公共类对象拿到分页对象(分页)
    Page findPageByQuery(CommonQuery commonQuery);

    //根据公共类对象拿到对应的所有数据(不分页)
    List<T> findByQuery(CommonQuery commonQuery);

    //根据jpql与对应的参数拿到数据
    // ...可变参数，传入的参数可以为多个
    List findByJpql(String jpql,Object... values);

}
