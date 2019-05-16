package test;

import com.majianwei.common.JsonResult;
import com.majianwei.common.UIPage;
import com.majianwei.domain.Menu;
import com.majianwei.repository.MenuRepository;
import com.majianwei.repository.SupplierRepository;
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
import com.majianwei.query.MenuQuery;
import com.majianwei.service.IMenuService;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicContext.xml")
public class MenuServiceTest {
    @Autowired
    private IMenuService menuService;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    //测试能不能拿到子菜单
    @Test
    public void findChildrenMenu() throws Exception{

        List<Menu> userMenu = menuService.findUserMenu(2L);
        userMenu.forEach(e-> System.out.println(e));
    }
    @Test
    public void test() throws Exception{
        List<Menu> menuList = menuService.findUserMenu(1L);
        menuList.forEach(e-> System.out.println(e));

    }
    @Test
    public void test2() throws Exception{
        List<Menu> byUser = menuRepository.findByUser(1L);
        byUser.forEach(e-> System.out.println(e));

    }
    @Test
    public void testSupplier() throws Exception{
        supplierRepository.findAll();
        System.out.println(supplierRepository.findAll());

    }

}