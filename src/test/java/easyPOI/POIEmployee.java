package easyPOI;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.util.Date;

@ExcelTarget("emp")
public class POIEmployee {

    @Excel(name = "用户名")
    private String name;
    @Excel(name="年龄")
    private Integer age;
    @Excel(name="邮箱",width = 20)
    private String email;
    @Excel(name = "性别",replace = {"男_true", "女_false"})
    private boolean sex = true;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }



}

