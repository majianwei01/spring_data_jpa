package com.majianwei.shiro;

import com.majianwei.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.Map;

public class FilterChainDefinitionMapFactory {
    public Map<String,String> createFilterChainDefinitionMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //登录页面放行
        map.put("/login", "anon");
        map.put("/main", "anon");
        map.put("/dept/index", "anon");
        //将easyui样式，js代码放行
        map.put("/easyui/**", "anon");
        map.put("/ccps_40_bov/**", "anon");
        map.put("/*.js", "anon");
        map.put("/*.css", "anon");
        /*<!--&lt;!&ndash;/depts/index = perms[depts:index]&ndash;&gt*/
        //拦截权限
        map.put("/employee/delete", " smartsellPermissionsFilter[employee:delete]");
        map.put("/**", "authc");

        return map;
    }
}
