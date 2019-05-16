<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/views/head.jsp"%>
    <%--引入easyui扩展库的包--%>
    <script src="/easyui/plugin/cellEdit/jeasyui.extensions.datagrid.getColumnInfo.js"></script>
    <script src="/easyui/plugin/cellEdit/jeasyui.extensions.datagrid.editors.js"></script>
    <script src="/easyui/plugin/cellEdit/jeasyui.extensions.datagrid.edit.cellEdit.js"></script>
    <%--引入相应的js--%>
    <script src="/js/model/purchasebill.js"></script>
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
            <%--easyui-datebox:日期输入框--%>
            时间: <input name="beginDate" class="easyui-datebox" style="width:120px">-
                    <input name="endDate" class="easyui-datebox" style="width:120px">
            状态:
                <%--easyui-combobox:下拉框--%>
            <select  class="easyui-combobox" name="status"  data-options="panelHeight:'auto'" style="width:100px;">
                <option value="">-请选择-</option>
                <option value="1">已审</option>
                <option value="0">待审</option>
                <option value="-1">作废</option>
            </select>
            <a href="#" class="easyui-linkbutton" data-method="search" iconCls="icon-search">搜索</a>
        </form>
    </div>
</div>

<%--展示purchasebill的grid--%>
<table id="purchasebillGrid" class="easyui-datagrid"
       data-options="url:'/purchasebill/page2',
       fit:true,
       fitColumns:true,
       singleSelect:true,
       pagination:true,
       <%--toobar调用工具栏--%>
       toolbar:'#gridTools'
    ">
    <thead>
    <tr>
            <th data-options="field:'vdate',width:100">交易时间</th>
            <th data-options="field:'totalamount',width:100">总价格</th>
            <th data-options="field:'totalnum',width:100">总数量</th>
            <th data-options="field:'inputtime',width:100">录入时间</th>
            <%--<th data-options="field:'auditortime',width:100">审核时间</th>--%>
            <th data-options="field:'status',width:100,formatter:statusFormat">审核状态</th>
            <th data-options="field:'supplier',width:100,formatter:objFormat">供应商</th>
            <th data-options="field:'inputUser',width:100,formatter:objFormat">录入者</th>
            <th data-options="field:'buyer',width:100,formatter:objFormat">采购员</th>
    
    </tr>
    </thead>
</table>
<%--
    对话框窗口(添加与修改的表单)
        closed:true:默认是关系的  modal:true:模态化 buttons:下方加按钮
--%>
<div id="purchasebillDlg" class="easyui-dialog" title="操作功能"
     data-options="closed:true,modal:true,buttons:'#purchasebillDlgBtns'" style="width:800px;padding:10px">
    <%--员工对应的Form表单--%>
    <form id="purchasebillForm" method="post">
        <input id="purchasebillId" type="hidden" name="id" />
        <table cellpadding="5">
            <tr>
                <td>交易时间</td>
                <td><input class="easyui-datebox" type="text" name="vdate" data-options="required:true"></input></td>
            </tr>

            <tr>
                <td>供应商</td>
                <td><input name="supplier.id" class="easyui-combobox" style="width:100px"
                           data-options="valueField:'id',textField:'name',url:'/util/suppliers',panelHeight:'auto'" /></td>
            </tr>

            <tr>
                <td>采购员</td>
                <td><input name="buyer.id" class="easyui-combobox" style="width:100px"
                           data-options="valueField:'id',textField:'username',url:'/util/buyers',panelHeight:'auto'" /></td>
            </tr>
        </table>

        <%--单据添加功能里明细的数据--%>
        <div id="itemsGridToolBar">
            <a href="#" id="btnInsert" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
            <a href="#" id="btnRemove" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
        </div>
        <table id="itemsGrid"></table>
    </form>
</div>
<%--弹出框对应的按键组--%>
<div id="purchasebillDlgBtns">
    <a href="javascript:void(0)" data-method="save" class="easyui-linkbutton c1">确认</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c3" onclick="$('#purchasebillDlg').dialog('close')">取消</a>
</div>



</body>
</html>