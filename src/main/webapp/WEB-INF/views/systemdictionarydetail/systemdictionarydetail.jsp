<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/views/head.jsp"%>
    <%--引入相应的js--%>
    <script src="/js/model/systemdictionarydetail.js"></script>
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
            名称: <input name="name" class="easyui-textbox" style="width:80px">
           
            <a href="#" class="easyui-linkbutton" data-method="search" iconCls="icon-search">搜索</a>
        </form>
    </div>
</div>

<%--展示systemdictionarydetail的grid--%>
<table id="systemdictionarydetailGrid" class="easyui-datagrid"
       data-options="url:'/systemdictionarydetail/page2',
       fit:true,
       fitColumns:true,
       singleSelect:true,
       pagination:true,
       <%--toobar调用工具栏--%>
       toolbar:'#gridTools'
    ">
    <thead>
    <tr>
            <th data-options="field:'name',width:100">name</th>
            <th data-options="field:'typesId',width:100">typesId</th>
    
    </tr>
    </thead>
</table>
<%--
    对话框窗口(添加与修改的表单)
        closed:true:默认是关系的  modal:true:模态化 buttons:下方加按钮
--%>
<div id="systemdictionarydetailDlg" class="easyui-dialog" title="操作功能"
     data-options="closed:true,modal:true,buttons:'#systemdictionarydetailDlgBtns'" style="width:340px;padding:10px">
    <%--员工对应的Form表单--%>
    <form id="systemdictionarydetailForm" method="post">
        <input id="systemdictionarydetailId" type="hidden" name="id" />
        <table cellpadding="5">
                    <tr>
                <td>name</td>
                <td><input class="easyui-validatebox" type="text" name="name" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>typesId</td>
                <td><input class="easyui-validatebox" type="text" name="typesId" data-options="required:true"></input></td>
            </tr>
                </table>
    </form>
</div>
<%--弹出框对应的按键组--%>
<div id="systemdictionarydetailDlgBtns">
    <a href="javascript:void(0)" data-method="save" class="easyui-linkbutton c1">确认</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c3" onclick="$('#systemdictionarydetailDlg').dialog('close')">取消</a>
</div>



</body>
</html>