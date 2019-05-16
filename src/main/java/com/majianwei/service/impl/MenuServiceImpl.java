package com.majianwei.service.impl;

import com.majianwei.common.UserContext;
import com.majianwei.domain.Employee;
import com.majianwei.domain.Menu;
import com.majianwei.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.majianwei.service.IMenuService;

import java.util.ArrayList;
import java.util.List;


@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu,Long> implements IMenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> findUserMenu(Long userId) {
        //定义一个父菜单的容器
        ArrayList<Menu> parentMenus = new ArrayList<>();
        //获取登录用户
        Employee loginUser = UserContext.getUser();
        //通过当前用户拿到对应菜单
        List<Menu> menuList = menuRepository.findByUser(loginUser.getId());
        //遍历菜单
        for (Menu menu : menuList) {
            //③.根据当前子菜单拿到对应的父菜单
            Menu parentMenu = menu.getParent();
            //④.判断父菜单容器中是否有这个父菜单,如果没有，就要加一个进去
            if (!parentMenus.contains(parentMenu)) {
                parentMenus.add(parentMenu);
            }
            //⑤.把子菜单加入到相应的父菜单中
            parentMenu.getChildren().add(menu);
        }
        return parentMenus;

    }

}
