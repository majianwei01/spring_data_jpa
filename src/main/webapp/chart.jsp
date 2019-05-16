<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--引入highcharts的支持包--%>
    <script src="/js/Highcharts/code/highcharts.js"></script>
    <script src="/js/Highcharts/code/highcharts-3d.js"></script>
    <script src="/js/Highcharts/code/modules/exporting.js"></script>
    <script src="/js/Highcharts/code/modules/export-data.js"></script>
</head>
<body>

<div id="container" style="height: 400px"></div>
<script type="text/javascript">
    Highcharts.chart('container', {
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
            text: '2014年浏览器的占比'
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
            data: [
                {
                    name: '火狐',
                    y: 30
                },
                {
                    name: '谷歌',
                    y: 60
                }
            ]
        }]
    });
</script>
</body>
</html>
