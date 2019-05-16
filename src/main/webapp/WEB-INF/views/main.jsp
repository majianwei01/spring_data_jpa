<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/1/20
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--添加shiro标签--%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>智销系统</title>

    <%--引入easyui文件--%>
    <%@include file="/WEB-INF/views/head.jsp"%>

    <%--给导航栏菜单添加选项卡--%>
    <script type="text/javascript">
        $(function () {
            $('#menuTree').tree({
                url:'/util/menu',
                //给树菜单绑定点击事件，添加选项卡
                onClick:function(node){
                if (node.url) {
                    //获取树标签的标签名
                    var title=node.text;
                    //根据标签名获得选项卡面板对象
                    var tab=$("#menuTab").tabs('getTab',title);
                    if (tab){
                        //easyui通过标签名选定选项卡面板
                        $("#menuTab").tabs('select',title);
                    } else{
                        //没有选项卡面板就添加一个
                        $('#menuTab').tabs('add',{
                            title:node.text,
                            content:'<iframe scrolling="auto" frameborder="0" style="height: 100%;width: 100%" src="'+node.url+'"></iframe>',
                            //是否可以关闭选项卡窗口
                            closable:true

                        })
                    }

                }

                }

            });
        })
    </script>
</head>

<!-- layout页面布局，这里以body标签作为标签容器，装入4个上下左中4个div标签 -->
<body class="easyui-layout">
<div data-options="region:'north'"
     style="height: 13%;background-image: url('img/dh.gif')">
    <h1 style="font-size: 20px;color: #e4d354">XXX公司智销系统</h1>
    <div style=" text-align: right ;margin-right:50px;">
        <%--在north板块添加用户名跟注销的功能--%>
            <%--<b>标签加粗字体--%>
            <b>
            <font color="#ffd700">欢迎您，<shiro:principal property="username"/><a href="/logout">退出登录</a></font>
            </b>
    </div>


</div>
<%--<div data-options="region:'south'" style="height: 8%;">--%>
    <%--<!-- 在页面南底部的位置设置移动条 -->--%>
    <%--<marquee style="color: red; font-weight: bold; font-size: 20px;">新年上新，潮鞋钜惠，赶紧买买买！！！</marquee>--%>
<%--</div>--%>

<div data-options="region:'west',split:false" title="导航菜单"
     style="width: 15%;background-color: #d4e4d6;">
    <ul id="menuTree"></ul>
</div>
<!-- 将div作为选项卡的容器  -->
<div id="menuTab" data-options="region:'center'" class="easyui-tabs">
    <div title="充值指引" style="padding: 10px;"></div>
</div>

</body>

</html>
