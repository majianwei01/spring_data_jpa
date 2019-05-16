package com.majianwei.common;

import com.majianwei.domain.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class UserContext {

    public static final String USER_IN_SESSION = "userInSession";

    //将当前登录用户放到session中
    public static void setUser(Employee loginUser){
        //1.拿到subject
        Subject subject = SecurityUtils.getSubject();
        //2.把员工放到session中去
        subject.getSession().setAttribute(USER_IN_SESSION, loginUser);
    }

    //获取到当前登录用户
    public static Employee getUser(){
        //1.拿到subject
        Subject subject = SecurityUtils.getSubject();
        //2.把员工放到session中去
        return (Employee)subject.getSession().getAttribute(USER_IN_SESSION);
    }
}
