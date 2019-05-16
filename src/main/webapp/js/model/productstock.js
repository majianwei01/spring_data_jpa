$(function () {

    //拿到页面中常用的一些组件
    //拿到有用户信息的组件
    var productstockGrid = $("#productstockGrid");
    var searchForm = $("#searchForm");
    var productstockDlg=$("#productstockDlg");
    var productstockForm=$("#productstockForm");

    //为所有页面上有 data-method属性的元素添加事件
    $("*[data-method]").on("click",function(){
        // console.debug($(this).data("method"));
        itsource[$(this).data("method")]();
    })

    itsource = {
        add(){
            //把表单进行清空
            productstockForm.form("clear");
            //把一些有data-hide的属性元素显示起来
            $("*[data-hide]").show();
            $("*[data-hide] input").validatebox("enable");
            //显示咱们的表单窗口
            productstockDlg.dialog("center").dialog("open");
        },

        save(){
            console.debug("56789");
            //准备路径(默认是保存)
            var url = "/productstock/save";
            //拿到表单的id(有值的话,路径进行修改)
            var id = $("#productstockId").val();
            if(id){
                url = "/productstock/update?_cmd=update";
                console.debug("56789");
            }
            //用easyui(form)提供的方案进行提交
            // 自动拿到所有数据，并且使用Ajax的方式提交
            productstockForm.form('submit', {
                url:url,
                //提交之前做的事情(返回false就不会提交)
                onSubmit: function(){
                    // 一般在这里面做验证功能
                    return productstockForm.form("validate");
                },
                //操作完成之后,执行这个代码(data就是后台返回的数据)
                // SpringMVC返回的就是一个JSON字符串,它返回的时候还会在响应中告诉前端,返回的是JSON数据
                // jQuery如果发现响应头是JSON,会就会自动帮我们把这个字符串转成JSON来使用
                // 记住:这个data是一个JSON格式字符串
                success:function(data){
                    //把JSON格式的字符串转成一个JSON的对象值
                    //var result = eval("("+data+")");
                    var result = JSON.parse(data); //标准的JSON格式
                    console.debug("56789"+result);
                    if(result.success){
                        //关闭窗口
                        productstockDlg.dialog("close");
                        //刷新grid
                        productstockGrid.datagrid("reload");
                    }else{
                        $.messager.alert('提示','删除失败! 原因:'+result.msg,'error');
                    }
                }
            });

        },

        // 前台删除
        delete(){
            //1.获取选中的是哪一行数据
            var row = productstockGrid.datagrid("getSelected");
            if(row){
                //3.用户选择是否要进行删除
                $.messager.confirm('提示','确认删除这行数据吗？',function(r){
                    if (r){
                        //4.如果要删除,Ajax请求进行删除
                        //5.拿到后台返回的结果: {success:true/false,msg:"出错原因!"}
                        $.get("/productstock/delete",{id:row.id},function(result){
                            console.debug(result);
                            if(result.success){
                                //6.删除成功的话,页面进行刷新
                                productstockGrid.datagrid("load");
                            }else{
                                $.messager.alert('提示','删除失败! 原因:'+result.msg,'error');
                            }
                        })
                    }
                });
            }else{
                //2.如果未选中数据,不做任何操作(或者给出提示)
                $.messager.alert('提示','请选定一行你要删除的数据!','info');
            }
        },
        update(){
            //必需选中相应的行,才可以进行修改功能
            var row = productstockGrid.datagrid("getSelected");
            if(row){
                //清空数据
                productstockForm.form("clear");
                //把一些有data-hide的属性元素隐藏起来
                $("*[data-hide]").hide();
                //禁用密码框
                $("*[data-hide] input").validatebox("disable");
                //<input name="department.id">
                // 关连对象回显需要做的操作
                //if(row.department){
                 //   row["department.id"] = row.department.id;
                //}
                //进行数据的回显(在清空后面)
                productstockForm.form("load",row);
                //弹出界面
                productstockDlg.dialog("center").dialog("open");
            }else{
                $.messager.alert('提示','请选择一条你要修改的数据!','info');
            }
        },
        search(){
            //拿到查询条件的值
            var params = searchForm.serializeObject();
            //根据查询的值刷新grid数据
            productstockGrid.datagrid("load",params);
        }
    };

})