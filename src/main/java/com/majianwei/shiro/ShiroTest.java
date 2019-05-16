package com.majianwei.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class ShiroTest {
    @Test
    public void test() throws Exception{
        //获取securitymanager工厂对象
        IniSecurityManagerFactory securityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //拿到securityManager对象
        SecurityManager securityManager = securityManagerFactory.createInstance();
        //将securu=ityManagery对象放到上下文中，方便在当前项目中任何位置都可以使用
        SecurityUtils.setSecurityManager(securityManager);

        //拿到用户名
        Subject currentUser = SecurityUtils.getSubject();
        //准备令牌
        UsernamePasswordToken token = new UsernamePasswordToken("root","123456");
        //登录
        currentUser.login(token);
        System.out.println("当前用户是否登录成功"+currentUser.isAuthenticated());
        //当前用户是否有xx角色
        System.out.println(currentUser.hasRole("itrole"));
        System.out.println(currentUser.hasRole("admin"));
        //判断当前用户是否有admin角色的delete权限
        System.out.println(currentUser.isPermitted("employee:delete"));

        //注销当前用户
        currentUser.logout();
        //注销后是否还有admin这个角色
        System.out.println(currentUser.hasRole("admin"));


    }
}
