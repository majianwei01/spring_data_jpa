package test;

import com.majianwei.domain.Employee;
import com.majianwei.domain.Product;
import com.majianwei.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.majianwei.service.IEmployeeService;
import util.MD5Util;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicContext.xml")
public class EmployServiceTest {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IProductService productService;

    @Test
    public void queryAll() throws Exception{
        employeeService.queryAll().forEach(e-> System.out.println(e));

    }
    //将所有数据的密码按照MD5，加盐加密的方式设置
    @Test
    public void testPwd() throws Exception{
        employeeService.queryAll().forEach(e-> {
            e.setPassword(MD5Util.creatMD5(e.getPassword()));
            employeeService.save(e);
        });
    }
    //测试能不能通过传入用户名拿到密码
    @Test
    public void testByUsername() throws Exception{

        Employee admin = employeeService.findByUsername("admin");
        System.out.println(admin.getPassword());

    }
    //测试能不能通过部门名称拿到对应部门的员工
    @Test
    public void test() throws Exception{
        List<Employee> buyersByDept = employeeService.findBuyersByDept();
        System.out.println(buyersByDept);

    }

}
