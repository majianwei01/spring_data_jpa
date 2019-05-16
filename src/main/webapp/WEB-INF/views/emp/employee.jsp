<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/views/head.jsp"%>
    <%--引入相应的js--%>
    <script src="/js/model/employee.js"></script>
</head>
<body>

<%--grid的工具栏--%>
<div id="gridTools" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="#" data-method="add" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="#" data-method="update" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="#" data-method="delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        <form id="searchForm">
            用户名: <input name="username" class="easyui-textbox" style="width:80px">
            邮件: <input name="email"  class="easyui-textbox" style="width:80px">
            部门:
            <input name="departmentId" class="easyui-combobox" style="width:100px"
                   data-options="valueField:'id',textField:'name',url:'/util/depts',panelHeight:'auto'" />
            <a href="#" class="easyui-linkbutton" data-method="search" iconCls="icon-search">搜索</a>
        </form>
    </div>
</div>

<%--展示employee的grid--%>
<table id="employeeGrid" class="easyui-datagrid"
       data-options="url:'/employee/page2',
       fit:true,
       fitColumns:true,
       singleSelect:true,
       pagination:true,
       <%--toobar调用工具栏--%>
       toolbar:'#gridTools'
    ">
    <thead>
    <tr>
        <th data-options="field:'username',width:100">名称</th>
        <th data-options="field:'headImage',width:100,formatter:imgFormat">头像</th>
        <th data-options="field:'password',width:100">密码</th>
        <th data-options="field:'email',width:100">邮件</th>
        <th data-options="field:'age',width:100">年龄</th>
        <th data-options="field:'department',width:100,formatter:objFormat">部门</th>
    </tr>
    </thead>
</table>
<%--
    对话框窗口(添加与修改的表单)
        closed:true:默认是关系的  modal:true:模态化 buttons:下方加按钮
--%>
<div id="employeeDlg" class="easyui-dialog" title="操作功能"
     data-options="closed:true,modal:true,buttons:'#employeeDlgBtns'" style="width:340px;padding:10px">
    <%--员工对应的Form表单--%>
    <form id="employeeForm" method="post">
        <input id="employeeId" type="hidden" name="id" />
        <table cellpadding="5">
            <tr>
                <td>用户名:</td>
                <td><input class="easyui-validatebox" type="text" name="username" data-options="required:true,validType:'checkName'"></input></td>
            </tr>
            <tr data-hide="true">
                <td>密码:</td>
                <td><input id="password" class="easyui-validatebox" type="password" name="password" data-options="required:true"></input></td>
            </tr>
            <tr data-hide="true">
                <td>重复密码:</td>
                <td><input class="easyui-validatebox" type="password" name="confirmPassword" validType="equals['password','id']"  data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>邮件:</td>
                <td><input class="easyui-validatebox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input class="easyui-validatebox" type="text" name="age" data-options="required:true,validType:['integer','integerRange[18,60]']"></input></td>
            </tr>
            <tr>
                <td>部门:</td>
                <td>
                    <input name="department.id" class="easyui-combobox" style="width:100px"
                           data-options="valueField:'id',textField:'name',url:'/util/depts',panelHeight:'auto'" />
                </td>
            </tr>
        </table>
    </form>
</div>
<%--弹出框对应的按键组--%>
<div id="employeeDlgBtns">
    <a href="javascript:void(0)" data-method="save" class="easyui-linkbutton c1">确认</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c3" onclick="$('#employeeDlg').dialog('close')">取消</a>
</div>



</body>
</html>

