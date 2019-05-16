package test;

import com.github.wenhao.jpa.Specifications;
import com.majianwei.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.majianwei.query.EmployeeQuery;
import com.majianwei.repository.EmployeeRepository;
import com.majianwei.service.IDepartmentService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicContext.xml")
public class EmpRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private IDepartmentService departmentService;

    //查询全部数据
    @Test
    public void findAll() throws Exception{
        List<Employee> list = employeeRepository.findAll();
        list.forEach(employee -> System.out.println(employee));
        System.out.println(employeeRepository.getClass());
    }
    //查询指定的一条数据
    @Test
    public void findOne() throws Exception{
        Employee employee = employeeRepository.findOne(1L);
        System.out.println(employee);
    }
    //添加一条数据
    @Test
    public void save() throws Exception{
        Employee employee = new Employee();
        employee.setUsername("源码时代");
        employee.setPassword("121212");
        employee.setAge(8);
        employee.setEmail("itsource.com");
        employee.setId(1L);
        employeeRepository.save(employee);
    }

    //删除
    @Test
    public void delete() throws Exception{
        employeeRepository.delete(274L);
    }

    //分页查询
    @Test
    public void page() throws Exception{
        PageRequest pageRequest = new PageRequest(0,5);//从第一页开始查询，每页展示5条数据
        Page<Employee> page = employeeRepository.findAll(pageRequest);
        page.forEach(e-> System.out.println(e));
    }

    //排序，根据age字段升序 asc升序，esc降序
    @Test
    public void sort() throws Exception{
        Sort sort = new Sort(Sort.Direction.ASC,"age");
        List<Employee> list = employeeRepository.findAll(sort);
        list.forEach(employee -> System.out.println(employee));
    }

    //模糊查询，先在接口类里定义模糊查询方法，然后调用该查询方法定义模糊查询的格式
    @Test
    public void fuzzyQuery() throws Exception{
        List<Employee> list = employeeRepository.findByUsernameLike("%asd%");
        list.forEach(employee -> System.out.println(employee));

        //自定义在接口类的方法---@Query("")
        List<Employee> list2 = employeeRepository.queryByUn("%222%");
        list2.forEach(employee -> System.out.println(employee));

    }

    //分页排序查询
    @Test
    public void test() throws Exception{
        //根据username进行排序
        Sort orders = new Sort(Sort.Direction.ASC,"username");
        //分页，并将排序对象传入
        PageRequest page = new PageRequest(0, 10,orders);
        Page<Employee> pagelist = employeeRepository.findAll(page);
        for (Employee employee : pagelist) {
            System.out.println(employee);
        }

    }
    //使用jpa-spec插件进行多条件查询---wenhao
    @Test
    public void testJpaSprc() throws Exception{
        Specification<Employee> spec = Specifications.<Employee>and().like("username", "%1%").build();
        List<Employee> list = employeeRepository.findAll(spec);
        list.forEach(e-> System.out.println(e));
    }
    //jpa-spec 条件加分页排序
    @Test
    public void testJpaSprc2() throws Exception{
        Specification<Employee> spec = Specifications.<Employee>and().like("username", "%1%")
                .like("email","%amd%").build();
        //排序
        Sort orders = new Sort(Sort.Direction.ASC,"username");
        //分页
        PageRequest page = new PageRequest(0, 5,orders);
        Page<Employee> list = employeeRepository.findAll(spec, page);
        list.forEach(e-> System.out.println(e));
    }
    @Test
    public void specQuery() throws Exception{
        //
        EmployeeQuery employeeQuery = new EmployeeQuery();
        employeeQuery.setUsername("asd");
        employeeQuery.setEmail("2");
        employeeQuery.setAge(5);
        //拿到spec规则
        Specification<Employee> spec = employeeQuery.createSpec();
        System.out.println("规则spec:"+spec);
        //sort排序对象
        Sort sort = new Sort(Sort.Direction.ASC, "username");
        //Sort sort = employeeQuery.creatSort();
        System.out.println("排序对象:"+sort);
        //分页对象
        PageRequest page = new PageRequest(0, 5,sort);

        Page<Employee> pagelist = employeeRepository.findAll(spec, page);
        pagelist.forEach(e-> System.out.println(e));


    }

    @Test
    public void datajpaQuery() throws Exception{
        EmployeeQuery query = new EmployeeQuery();
        //query.setUsername("1");
        //query.setAge(5);

        //准备查询规则spec
        //通过子类对象可以调用获取到苏所有需要的参数，查询方法需要什么参数就获取哪些参数
        query.setEmail("it");
        query.setOrderType("asfhdf");
        query.setOrderFiled("id");

        //这里原来第一次自定义的接口继承了增强了的接口BaseRepository，所以继承了方法
        Page pageByQuery = employeeRepository.findPageByQuery(query);//
        pageByQuery.forEach(e-> System.out.println(e));


    }

    @Test
    public void  departmentList() throws Exception{
//        List<Department> departments = departmentService.queryAll();
//        departments.forEach(e-> System.out.println(e));

        List<Employee> list = employeeRepository.findAll();
        list.forEach(e-> System.out.println("===================="+list));

    }

}
