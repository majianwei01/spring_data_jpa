package com.majianwei.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.majianwei.query.CommonQuery;
import com.majianwei.repository.BaseRepository;
import com.majianwei.service.IBaseService;

import java.io.Serializable;
import java.util.List;

//给业务实现类添加事务
//查询不改变事务，只读
@Transactional(readOnly = true , propagation = Propagation.SUPPORTS)
public class BaseServiceImpl<T,ID extends Serializable> implements IBaseService<T, ID > {

    //BaseRepository是没有被spring管理的，可以定义很多方法，可以写很多是实现
    //必须加上泛型，因为可以添加的类型有很多
    @Autowired
    private BaseRepository<T,ID> baseRepository;

    @Override
    @Transactional
    public void save(T t) {
        baseRepository.save(t);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        baseRepository.delete(id);
    }

    @Override
    public T queryOne(ID id) {
        return baseRepository.findOne(id);
    }

    @Override
    public List<T> queryAll() {
        return baseRepository.findAll();
    }

    @Override
    public Page findPageByQuery(CommonQuery commonQuery) {
        return baseRepository.findPageByQuery(commonQuery);
    }

    @Override
    public List<T> findByQuery(CommonQuery commonQuery) {
        return baseRepository.findByQuery(commonQuery);
    }

    @Override
    public List findByJpql(String jpql, Object... values) {
        return baseRepository.findByJpql(jpql, values);
    }
}
