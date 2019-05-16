package com.majianwei.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SmartsellPermissionsFilter extends PermissionsAuthorizationFilter {

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException{
        //拿到当前用户
        Subject subject = this.getSubject(request, response);
        //如果当前用户为空就跳转到登录界面
        if (subject.getPrincipal()==null){
            this.saveRequestAndRedirectToLogin(request, response);
        }else{
            //转换成http格式的请求响应
            HttpServletRequest req=(HttpServletRequest)request;
            HttpServletResponse resp=(HttpServletResponse)response;
            //获得请求头，"X-Requested-With"为请求头的键
            String header = req.getHeader("X-Requested-With");
            if ("XMLHttpRequest".equals(header)){
                resp.setContentType("application/json;charset=utf-8");
                resp.getWriter().print("{\"success\":false,\"msg\":\"抱歉，你没有权限!\"}");
            }else{
                //拿到没有权限需要跳转的路径
                String unauthorizedUrl = this.getUnauthorizedUrl();
                //如果有这个路径，就进行跳转
                if (StringUtils.hasText(unauthorizedUrl)) {
                    WebUtils.issueRedirect(request, response, unauthorizedUrl);
                } else {
                    WebUtils.toHttp(response).sendError(401);
                }


            }

        }
        return false;
    }


}
