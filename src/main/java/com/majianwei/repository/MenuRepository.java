package com.majianwei.repository;

import com.majianwei.domain.Menu;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MenuRepository extends BaseRepository<Menu,Long>{

    //根据用户名拿到对应的所有子菜单
    @Query("select distinct m from Employee e join e.roles r join r.permissions p join p.menu m where e.id = ?1")
    List<Menu> findByUser(Long userId);


}