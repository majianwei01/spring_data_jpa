package easyPOI;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EasyPoiTest {

    @Test
    public void testCreate() throws Exception{
        //创建相应的员工对象将其封装到一个list中
        List<POIEmployee> list = new ArrayList<>();
        POIEmployee emp01 = new POIEmployee();
        emp01.setName("小明同学");
        emp01.setAge(18);
        emp01.setEmail("123@qq.com");
        emp01.setSex(true);

        POIEmployee emp02 = new POIEmployee();
        emp02.setName("小张同学");
        emp02.setAge(28);
        emp02.setEmail("zhang@qq.com");
        list.add(emp01);
        list.add(emp02);
        emp02.setSex(false);


        //easypoi怎么把这个数据导出
        /**
         * 参数一:设置表参数
         * 参数二:要操作的实体类型
         * 参数三:导入的数据
         */
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), POIEmployee.class, list);
        FileOutputStream fos = new FileOutputStream("easypoiemp.xls");
        workbook.write(fos);
        fos.close();
    }


}
