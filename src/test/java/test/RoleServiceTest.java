package test;

import com.majianwei.common.JsonResult;
import com.majianwei.common.UIPage;
import com.majianwei.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.majianwei.query.RoleQuery;
import com.majianwei.service.IRoleService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicContext.xml")
public class RoleServiceTest {
    @Autowired
    private IRoleService roleService;

    @Test
    public void queryAll() throws Exception{
        roleService.queryAll().forEach(e-> System.out.println(e));

    }

}