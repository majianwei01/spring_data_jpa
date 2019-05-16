package com.majianwei.service;

import com.majianwei.domain.Menu;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IMenuService extends IBaseService<Menu,Long>{

    List<Menu> findUserMenu(Long userId);


}