<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/views/head.jsp"%>
    <%--引入相应的js--%>
    <script src="/js/model/stockincomebillitem.js"></script>
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

<%--展示stockincomebillitem的grid--%>
<table id="stockincomebillitemGrid" class="easyui-datagrid"
       data-options="url:'/stockincomebillitem/page2',
       fit:true,
       fitColumns:true,
       singleSelect:true,
       pagination:true,
       <%--toobar调用工具栏--%>
       toolbar:'#gridTools'
    ">
    <thead>
    <tr>
            <th data-options="field:'price',width:100">price</th>
            <th data-options="field:'num',width:100">num</th>
            <th data-options="field:'amount',width:100">amount</th>
            <th data-options="field:'descs',width:100">descs</th>
            <th data-options="field:'productId',width:100">productId</th>
            <th data-options="field:'billId',width:100">billId</th>
    
    </tr>
    </thead>
</table>
<%--
    对话框窗口(添加与修改的表单)
        closed:true:默认是关系的  modal:true:模态化 buttons:下方加按钮
--%>
<div id="stockincomebillitemDlg" class="easyui-dialog" title="操作功能"
     data-options="closed:true,modal:true,buttons:'#stockincomebillitemDlgBtns'" style="width:340px;padding:10px">
    <%--员工对应的Form表单--%>
    <form id="stockincomebillitemForm" method="post">
        <input id="stockincomebillitemId" type="hidden" name="id" />
        <table cellpadding="5">
                    <tr>
                <td>price</td>
                <td><input class="easyui-validatebox" type="text" name="price" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>num</td>
                <td><input class="easyui-validatebox" type="text" name="num" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>amount</td>
                <td><input class="easyui-validatebox" type="text" name="amount" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>descs</td>
                <td><input class="easyui-validatebox" type="text" name="descs" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>productId</td>
                <td><input class="easyui-validatebox" type="text" name="productId" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>billId</td>
                <td><input class="easyui-validatebox" type="text" name="billId" data-options="required:true"></input></td>
            </tr>
                </table>
    </form>
</div>
<%--弹出框对应的按键组--%>
<div id="stockincomebillitemDlgBtns">
    <a href="javascript:void(0)" data-method="save" class="easyui-linkbutton c1">确认</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c3" onclick="$('#stockincomebillitemDlg').dialog('close')">取消</a>
</div>



</body>
</html>