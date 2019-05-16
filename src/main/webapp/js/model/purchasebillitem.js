function formatStatus(v) {
    if(v==-1){
        return "<s style='color: #8aa4af'>作废</s>";
    }else if(v==1){
        return "<span style='color: #00ee00'>已审</span>";
    }else{
        return "<span style='color: #c9302c'>待审</span>";
    }
}
$(function () {

    //拿到页面中常用的一些组件
    //拿到有用户信息的组件
    var itemsGrid = $("#itemsGrid");
    var searchForm = $("#searchForm");
    var chartsDlg = $("#chartsDlg");


    //为所有页面上有 data-method属性的元素添加事件
    $("*[data-method]").on("click",function(){
        // console.debug($(this).data("method"));
        itsource[$(this).data("method")]();
    })

    itsource = {
        search(){
            //拿到查询条件的值
            var params = searchForm.serializeObject();
            //根据查询的值刷新grid数据
            itemsGrid.datagrid("load",params);
        },
        chart3d(){
            //打开容器并且居中
            chartsDlg.dialog("center").dialog("open");
            //拿到查询条件的值
            var params = searchForm.serializeObject();
            //通过Ajax请求去获取数据
            $.post("/purchasebillitem/findCharts",params,function (result) {
                //在里面加一个饼图
                Highcharts.chart('chartsDlg', {
                    chart: {
                        type: 'pie', //饼图的类型
                        options3d: {
                            enabled: true,
                            alpha: 45, //倾斜度
                            beta: 0
                        }
                    },
                    //标题
                    title: {
                        text: '采购报表数据'
                    },
                    tooltip: {
                        //鼠标指上面的展示
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            depth: 35, //深度
                            dataLabels: {
                                enabled: true,
                                format: '{point.name}'
                            }
                        }
                    },
                    series: [{
                        type: 'pie',
                        name: '占比',
                        data: result
                    }]
                });
            },"json")

        }
    }
    itemsGrid.datagrid({
        fit:true,
        rownumbers:true,
        remoteSort:false,
        nowrap:false,
        fitColumns:true,
        toolbar:"#gridTools",
        url:'/purchasebillitem/findItems', //相应的数据
        columns:[[
            {field:'id',title:'编号',width:30},
            {field:'supplierName',title:'供应商',width:100},
            {field:'buyerName',title:'采购名',width:100},
            {field:'productName',title:'产品',width:100},
            {field:'productTypeName',title:'产品类型',width:100},
            {field:'vdate',title:'采购日期',width:140},
            {field:'num',title:'数量',width:100},
            {field:'price',title:'单价',width:100},
            {field:'amount',title:'小计',width:100},
            {field:'status',title:'状态',width:100,formatter:formatStatus}
        ]],
        groupField:'supplierName', //根据供应商名字分组
        view: groupview,
        groupFormatter:function(value, rows){ //分组格式化 value:分组的值  rows:表格的所有行
            console.debug(rows);
            //1.准备总金额与数量
            var totalAmount = 0;
            var totalNum = 0;
            //2.遍历这个值
            for(let row of rows){
                totalAmount += row.amount;
                totalNum += row.num;
            }
            return value + ' - ' + rows.length + '条数据 '
                +'<span style="color: #3c8b3c;">共'+totalNum+'件商品</span>'
                + '<span style="color:red;">总金额:'+totalAmount +"</span>";
        }
    });
})

