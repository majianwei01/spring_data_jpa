<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/views/head.jsp"%>
    <%--引入鼠标悬浮的js插件--%>
    <script type="text/javascript" src="/easyui/plugin/tooltip/jeasyui.extensions.datagrid.tooltip.js"></script>
    <%--引入相应的js--%>
    <script src="/js/model/product.js"></script>
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

<%--展示product的grid--%>
<table id="productGrid" class="easyui-datagrid"
       data-options="url:'/product/page2',
       fit:true,
       fitColumns:true,
       fixed:true,
       toolbar:'#gridTools',
       singleSelect:true,
       pagination:true,
       <%--onRowContextMenu:showMenu,--%>
       <%--onLoadSuccess:loadSuccess,--%>

       <%--iconCls='icon-save',--%>
       <%--enableHeaderClickMenu=true,--%>
       <%--rownumbers=true,--%>
">
    <thead>
    <tr>
            <th data-options="field:'name',width:100">名字</th>
            <th data-options="field:'color',width:100,formatter:formatColor">颜色</th>
            <th data-options="field:'pic',width:100,formatter:formatImg">图片</th>
            <th data-options="field:'smallpic',width:100">smallpic</th>
            <th data-options="field:'costprice',width:100">成本价</th>
            <th data-options="field:'saleprice',width:100">售价</th>
            <th data-options="field:'types',width:100,formatter:formatObj">typesId</th>
            <th data-options="field:'unit',width:100,formatter:formatObj">unitId</th>
            <th data-options="field:'brand',width:100,formatter:formatObj">brandId</th>
    
    </tr>
    </thead>
</table>
<%--
    对话框窗口(添加与修改的表单)
        closed:true:默认是关系的  modal:true:模态化 buttons:下方加按钮
--%>
<div id="productDlg" class="easyui-dialog" title="操作功能"
     data-options="closed:true,modal:true,buttons:'#productDlgBtns'" style="width:340px;padding:10px">
    <%--员工对应的Form表单--%>
    <form id="productForm" method="post">
        <input id="productId" type="hidden" name="id" />
        <table cellpadding="5">
                    <tr>
                <td>name</td>
                <td><input class="easyui-validatebox" type="text" name="name" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>color</td>
                <td><input class="easyui-validatebox" type="text" name="color" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>pic</td>
                <td><input class="easyui-validatebox" type="text" name="pic" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>smallpic</td>
                <td><input class="easyui-validatebox" type="text" name="smallpic" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>costprice</td>
                <td><input class="easyui-validatebox" type="text" name="costprice" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>saleprice</td>
                <td><input class="easyui-validatebox" type="text" name="saleprice" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>typesId</td>
                <td><input class="easyui-validatebox" type="text" name="typesId" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>unitId</td>
                <td><input class="easyui-validatebox" type="text" name="unitId" data-options="required:true"></input></td>
            </tr>
                    <tr>
                <td>brandId</td>
                <td><input class="easyui-validatebox" type="text" name="brandId" data-options="required:true"></input></td>
            </tr>
                </table>
    </form>
</div>
<%--弹出框对应的按键组--%>
<div id="productDlgBtns">
    <a href="javascript:void(0)" data-method="save" class="easyui-linkbutton c1">确认</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c3" onclick="$('#productDlg').dialog('close')">取消</a>
</div>



</body>
</html>