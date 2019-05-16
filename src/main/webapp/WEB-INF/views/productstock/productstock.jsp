<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/views/head.jsp"%>
    <%--引入相应的js--%>
    <script src="/js/model/productstock.js"></script>
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

<%--展示productstock的grid--%>
<table id="productstockGrid" class="easyui-datagrid"
       data-options="url:'/productstock/page2',
       fit:true,
       fitColumns:true,
       singleSelect:true,
       pagination:true,
       <%--toobar调用工具栏--%>
       toolbar:'#gridTools'
    ">
    <thead>
    <tr>
            <th data-options="field:'num',width:100">num</th>
            <th data-options="field:'amount',width:100">amount</th>
            <th data-options="field:'price',width:100">price</th>
            <th data-options="field:'incomedate',width:100">incomedate</th>
            <th data-options="field:'warning',width:100">warning</th>
            <th data-options="field:'topnum',width:100">topnum</th>
            <th data-options="field:'bottomnum',width:100">bottomnum</th>
            <th data-options="field:'productId',width:100">productId</th>
            <th data-options="field:'depotId',width:100">depotId</th>
    
    </tr>
    </thead>
</table>
<%--
    对话框窗口(添加与修改的表单)
        closed:true:默认是关系的  modal:true:模态化 buttons:下方加按钮
--%>
<div id="productstockDlg" class="easyui-dialog" title="操作功能"
     data-options="closed:true,modal:true,buttons:'#productstockDlgBtns'" style="width:340px;padding:10px">
    <%--员工对应的Form表单--%>
    <form id="productstockForm" method="post">
        <input id="productstockId" type="hidden" name="id" />
        <table cellpadding="5">
                    <tr>
                <td>num</td>
                <td><input class="easyui-validatebox" type="text" name="num" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>amount</td>
                <td><input class="easyui-validatebox" type="text" name="amount" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>price</td>
                <td><input class="easyui-validatebox" type="text" name="price" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>incomedate</td>
                <td><input class="easyui-validatebox" type="text" name="incomedate" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>warning</td>
                <td><input class="easyui-validatebox" type="text" name="warning" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>topnum</td>
                <td><input class="easyui-validatebox" type="text" name="topnum" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>bottomnum</td>
                <td><input class="easyui-validatebox" type="text" name="bottomnum" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>productId</td>
                <td><input class="easyui-validatebox" type="text" name="productId" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>depotId</td>
                <td><input class="easyui-validatebox" type="text" name="depotId" data-options="required:true"></input></td>
            </tr>
                </table>
    </form>
</div>
<%--弹出框对应的按键组--%>
<div id="productstockDlgBtns">
    <a href="javascript:void(0)" data-method="save" class="easyui-linkbutton c1">确认</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c3" onclick="$('#productstockDlg').dialog('close')">取消</a>
</div>



</body>
</html>