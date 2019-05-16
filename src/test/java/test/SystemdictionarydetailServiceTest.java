package test;

import com.majianwei.common.JsonResult;
import com.majianwei.common.UIPage;
import com.majianwei.domain.Systemdictionarydetail;
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
import com.majianwei.query.SystemdictionarydetailQuery;
import com.majianwei.service.ISystemdictionarydetailService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicContext.xml")
public class SystemdictionarydetailServiceTest {
    @Autowired
    private ISystemdictionarydetailService systemdictionarydetailService;

    @Test
    public void queryAll() throws Exception{
        systemdictionarydetailService.queryAll().forEach(e-> System.out.println(e));

    }

}