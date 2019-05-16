<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/views/head.jsp"%>
    <%--引入相应的js--%>
    <script src="/js/model/stockincomebill.js"></script>
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

<%--展示stockincomebill的grid--%>
<table id="stockincomebillGrid" class="easyui-datagrid"
       data-options="url:'/stockincomebill/page2',
       fit:true,
       fitColumns:true,
       singleSelect:true,
       pagination:true,
       <%--toobar调用工具栏--%>
       toolbar:'#gridTools'
    ">
    <thead>
    <tr>
            <th data-options="field:'vdate',width:100">vdate</th>
            <th data-options="field:'totalamount',width:100">totalamount</th>
            <th data-options="field:'totalnum',width:100">totalnum</th>
            <th data-options="field:'inputtime',width:100">inputtime</th>
            <th data-options="field:'auditortime',width:100">auditortime</th>
            <th data-options="field:'status',width:100">status</th>
            <th data-options="field:'supplierId',width:100">supplierId</th>
            <th data-options="field:'auditorId',width:100">auditorId</th>
            <th data-options="field:'inputuserId',width:100">inputuserId</th>
            <th data-options="field:'keeperId',width:100">keeperId</th>
            <th data-options="field:'depotId',width:100">depotId</th>
    
    </tr>
    </thead>
</table>
<%--
    对话框窗口(添加与修改的表单)
        closed:true:默认是关系的  modal:true:模态化 buttons:下方加按钮
--%>
<div id="stockincomebillDlg" class="easyui-dialog" title="操作功能"
     data-options="closed:true,modal:true,buttons:'#stockincomebillDlgBtns'" style="width:340px;padding:10px">
    <%--员工对应的Form表单--%>
    <form id="stockincomebillForm" method="post">
        <input id="stockincomebillId" type="hidden" name="id" />
        <table cellpadding="5">
                    <tr>
                <td>vdate</td>
                <td><input class="easyui-validatebox" type="text" name="vdate" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>totalamount</td>
                <td><input class="easyui-validatebox" type="text" name="totalamount" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>totalnum</td>
                <td><input class="easyui-validatebox" type="text" name="totalnum" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>inputtime</td>
                <td><input class="easyui-validatebox" type="text" name="inputtime" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>auditortime</td>
                <td><input class="easyui-validatebox" type="text" name="auditortime" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>status</td>
                <td><input class="easyui-validatebox" type="text" name="status" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>supplierId</td>
                <td><input class="easyui-validatebox" type="text" name="supplierId" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>auditorId</td>
                <td><input class="easyui-validatebox" type="text" name="auditorId" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>inputuserId</td>
                <td><input class="easyui-validatebox" type="text" name="inputuserId" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>keeperId</td>
                <td><input class="easyui-validatebox" type="text" name="keeperId" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>depotId</td>
                <td><input class="easyui-validatebox" type="text" name="depotId" data-options="required:true"></input></td>
            </tr>
                </table>
    </form>
</div>
<%--弹出框对应的按键组--%>
<div id="stockincomebillDlgBtns">
    <a href="javascript:void(0)" data-method="save" class="easyui-linkbutton c1">确认</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c3" onclick="$('#stockincomebillDlg').dialog('close')">取消</a>
</div>



</body>
</html>