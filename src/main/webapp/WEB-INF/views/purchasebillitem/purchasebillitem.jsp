<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/views/head.jsp"%>
    <%--引入groupview--%>
    <script src="/easyui/plugin/datagridview/datagrid-groupview.js"></script>
    <script src="/js/Highcharts/code/highcharts.js"></script>
    <script src="/js/Highcharts/code/highcharts-3d.js"></script>
    <script src="/js/Highcharts/code/modules/exporting.js"></script>
    <script src="/js/Highcharts/code/modules/export-data.js"></script>
    <%--引入相应的js--%>
    <script src="/js/model/purchasebillitem.js"></script>
</head>
<body>

<%--grid的工具栏--%>
<div id="gridTools" style="padding:5px;height:auto">
    <%--<div id="cc" class="easyui-calendar"></div>--%>
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
                <select  class="easyui-combobox" name="groupBy"  data-options="panelHeight:'auto'" style="width:100px;">
                    <option value="1">供应商</option>
                    <option value="2">采购员</option>
                    <option value="3">月份</option>
                </select>
            <a href="#" class="easyui-linkbutton" data-method="search" iconCls="icon-search">搜索</a>
            <a href="#" class="easyui-linkbutton" data-method="chart3d" iconCls="icon-search">3D饼图</a>
    </form>
</div>

<table id="itemsGrid"></table>
<%--展示图表的弹出框--%>
<div id="chartsDlg" class="easyui-dialog" title="图表"
     data-options="closed:true,modal:true" style="height:350px;width:500px;padding:10px">
</div>

</body>
</html>