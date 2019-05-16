package com.majianwei.controller;

import com.majianwei.common.JsonResult;
import com.majianwei.common.UserContext;
import com.majianwei.domain.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


    //登录界面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        if (UserContext.getUser()!=null){
            return "main";
        }
        return "login";

    }
    //传入用户名和密码后跳转到主界面
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult loginAfter(String username,String password){
        //拿到用户名
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            //准备令牌
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                return new JsonResult(false, "该用户不存在");
            }catch (IncorrectCredentialsException e){
                e.printStackTrace();
                return new JsonResult(false, "该用户名或者密码错误");
            }catch (AuthenticationException e){
                return new JsonResult(false, "账号异常。。。");
            }
        }
        Employee employee = (Employee) currentUser.getPrincipal();
        UserContext.setUser(employee);
        return new JsonResult();
    }
    //注销用户，返回登录页面
    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/login";


    }
}

