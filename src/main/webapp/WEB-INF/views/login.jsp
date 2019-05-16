<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <%--解决html复制到jsp乱码问题--%>
    <%@ page pageEncoding="utf-8"%>
    <title>后台系统登录</title>
    <link rel="stylesheet" type="text/css" href="/ccps_40_bov/css/style.css" />
    <link rel="stylesheet" type="text/css" href="/ccps_40_bov/css/body.css"/>
    <%--引入easyui--%>
    <%@ include file="/WEB-INF/views/head.jsp"%>
    <script>
        //登录的提交
        function submitForm() {
            $("#loginForm").form('submit',{
                url:"/login",
                success:function (data) {
                    // 将json字符串转换成json对象
                    let result=JSON.parse(data);
                    if (result.success) {
                        //登录成功的话就跳转到主页面
                        window.location.href="/main";
                    }else{
                        $.messager.alert('出错，用户名或者密码不正确',result.msg,"error");
                    }
                }
            });
        }
        //将表单重置，清空方法是"clear"
        function resetForm() {
            $("#loginForm").form("clear")
        }
        //按键监听，回车建登录
        $(document.documentElement).on("keyup", function(event) {
            console.debug(event);
        })
    </script>
</head>
<body>
<div class="container">
    <section id="content">
        <form id="loginForm" action="" class="easyui-form" method="post">
            <h1>后台系统登录</h1>
            <div>
                <input type="text" class="easyui-validatebox" placeholder="用户名" required="" name="username" />
            </div>
            <div>
                <input type="password"  class="easyui-validatebox" placeholder="密码" required="" name="password" />
            </div>
            <div class="">
                <span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>			</div>
            <div>
                <!-- <input type="submit" value="Log in" /> -->
                <input type="submit" value="登录" class="easyui-linkbutton" onclick="submitForm();" id="js-btn-login"/>
                <!-- <a href="#">Register</a> -->
            </div>
        </form><!-- form -->
    </section><!-- content -->
</div>
<!-- container -->


<br><br><br><br>
<div style="text-align:center;">
    <p>来源:More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
</div>
</body>
</html>