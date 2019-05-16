package com.majianwei.template;


import com.majianwei.domain.Department;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

import java.io.StringWriter;

public class VelocityTest {
    //模板技术:数据+模板=文本(输出)
    @Test
    public void testHello() throws Exception{
        //创建Velocity的模板引擎
        VelocityEngine ve = new VelocityEngine();
        //Template：模板
        // 注意:测试默认是从当前项目开始找的路径
        Template template = ve.getTemplate("com/majianwei/template/index.vm","utf-8");

        //创建Velocity上下文对象
        VelocityContext velocityContext = new VelocityContext();
        //在Velocity上下文对象中放数据
        velocityContext.put("txt", "小红帽!");

        //准备一个对象
        Department dept = new Department();
        //dept.setName("莫凡");
        velocityContext.put("dept", dept);

        //字符串输出(文件流的话可以生成文件 )
        StringWriter stringWriter = new StringWriter();
        //数据(velocityContext) + 模板(template) = stringWriter
        template.merge(velocityContext, stringWriter);
        System.out.println(stringWriter.toString());
    }
}
