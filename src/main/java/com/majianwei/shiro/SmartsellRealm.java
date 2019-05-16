package com.majianwei.shiro;

import com.majianwei.domain.Employee;
import com.majianwei.service.IEmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import util.MD5Util;

import java.util.HashSet;
import java.util.Set;

public class SmartsellRealm extends AuthorizingRealm {

    @Autowired
    private IEmployeeService employeeService;
    @Override
    public String getName() {
        return "SmartsellRealm";
    }

    //授权的验证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //拿到用户名
        Employee primaryName= (Employee)principals.getPrimaryPrincipal();
        //根据用户名拿到对应的角色与权限
        Set<String> roles = findRolesBy(primaryName.getUsername());
        Set<String> perms = findPermsBy(primaryName.getUsername());

        //创建权限对象，将拿到的角色与权限传入并返回
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(perms);
        return authorizationInfo;


    }
    //根据用户名拿到对应的角色
    public Set<String> findRolesBy(String username){
        Set<String> set = new HashSet<String>();
        set.add("admin");
        set.add("guest");
        return set;
    }
    //根据用户名拿到对应的权限
    public Set<String> findPermsBy(String username){
        Set<String> set = new HashSet<String>();
//        set.add("employee:delete");
        return set;
    }

    //登录的验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        //session.setAttribute(employeeInSessoin, Employee);
        //先拿到令牌
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        //通过令牌拿到用户名
        String username = token.getUsername();
        //传入用户名从数据库拿到用户对象
        Employee employee = employeeService.findByUsername(username);
        if (employee==null){
            return null;
        }
        //从数据库拿到当前用户的密码
        String password = employee.getPassword();
        //加盐值
        ByteSource salt = ByteSource.Util.bytes(MD5Util.SALT);//？？？？？？？？？？？？？？？？？？？？
        //传入用户名，密码，盐值，自定义reaml名字去跟前台传入的用户名跟密码进行验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(employee,password,salt,getName());
        return authenticationInfo;
    }
//    //模拟数据库，通过传入用户名拿到密码
//    private String getByUsername(String username){
//        if("admin".equals(username)){
//            return "0a88b1af592f261adf89cbe8eeac3ecc";
//        }else if("guest".equals(username)){
//            return "456";
//        }
//        return null;
//    }
}
