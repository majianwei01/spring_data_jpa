package com.majianwei.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import com.majianwei.query.CommonQuery;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * 实现父类中的三个方法
 * @param <T>
 * @param <ID>
 */
public class BaseRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {

    private final EntityManager entityManager;

    //必需要实现父类的这个构造器---？？？
    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }

    //获取分页对象
    @Override
    public Page findPageByQuery(CommonQuery commonQuery) {
        //1.获取spec查询g规则
        Specification spec = commonQuery.createSpec();
        //2.获取排序对象
        Sort sort = commonQuery.creatSort();
        System.out.println(sort+"dfafsadfsdfsdfasffd");
        //3.传入分页，排序对象返回
        Pageable pagelist = new PageRequest(commonQuery.getJpapage(), commonQuery.getPageSize(),sort);
        Page<T> page = super.findAll(spec, pagelist);
        return page;

    }

    //传入参数，获取对应条件的总数据（没有分页）
    @Override
    public List<T> findByQuery(CommonQuery commonQuery) {
        //1.获取spec查询g规则
        Specification spec = commonQuery.createSpec();
        //2.获取排序对象
        Sort sort = commonQuery.creatSort();
        //3:拿到数据返回
        return findAll(spec, sort);
    }

    @Override
    public List findByJpql(String jpql, Object... values) {
        //创建query对象
        Query query = entityManager.createQuery(jpql);
        //将values数据遍历传入query对象中
        if (values!=null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i + 1, values[i]);
            }
        }
        //第三步：返回数据
        return query.getResultList();
    }
}
