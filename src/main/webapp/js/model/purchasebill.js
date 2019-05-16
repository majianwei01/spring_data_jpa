function objFormat(v,r,i){
    if (v){
        return v.name || v.username;
    }
    return "";
}

function statusFormat(v,r,i){
    if (v == -1){
        return "<s style='color: #4c4c4c'>作废</s>";
    }else if(v == 1){
        return "<span style='color: #00ee00'>已审</span>";
    }else if(v == 0){
        return "<span style='color: #CC2222'>待审</span>";
    }

}
$(function () {

    //拿到页面中常用的一些组件
    //拿到有用户信息的组件
    var purchasebillGrid = $("#purchasebillGrid");
    var searchForm = $("#searchForm");
    var purchasebillDlg=$("#purchasebillDlg");
    var purchasebillForm=$("#purchasebillForm");

    //为所有页面上有 data-method属性的元素添加事件
    $("*[data-method]").on("click",function(){
        // console.debug($(this).data("method"));
        itsource[$(this).data("method")]();
    })

    itsource = {
        add(){
            //把表单进行清空
            purchasebillForm.form("clear");
            //把一些有data-hide的属性元素显示起来
            $("*[data-hide]").show();
            $("*[data-hide] input").validatebox("enable");
            //显示咱们的表单窗口
            purchasebillDlg.dialog("center").dialog("open");
        },

        save(){
            console.debug("56789");
            //准备路径(默认是保存)
            var url = "/purchasebill/save";
            //拿到表单的id(有值的话,路径进行修改)
            var id = $("#purchasebillId").val();
            if(id){
                url = "/purchasebill/update?_cmd=update";
                console.debug("56789");
            }
            //用easyui(form)提供的方案进行提交
            // 自动拿到所有数据，并且使用Ajax的方式提交
            purchasebillForm.form('submit', {
                url:url,
                //提交之前做的事情(返回false就不会提交)
                onSubmit: function(){
                    // 一般在这里面做验证功能
                    return purchasebillForm.form("validate");
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
                        purchasebillDlg.dialog("close");
                        //刷新grid
                        purchasebillGrid.datagrid("reload");
                    }else{
                        $.messager.alert('提示','删除失败! 原因:'+result.msg,'error');
                    }
                }
            });

        },

        // 前台删除
        delete(){
            //1.获取选中的是哪一行数据
            var row = purchasebillGrid.datagrid("getSelected");
            if(row){
                //3.用户选择是否要进行删除
                $.messager.confirm('提示','确认删除这行数据吗？',function(r){
                    if (r){
                        //4.如果要删除,Ajax请求进行删除
                        //5.拿到后台返回的结果: {success:true/false,msg:"出错原因!"}
                        $.get("/purchasebill/delete",{id:row.id},function(result){
                            console.debug(result);
                            if(result.success){
                                //6.删除成功的话,页面进行刷新
                                purchasebillGrid.datagrid("load");
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
            var row = purchasebillGrid.datagrid("getSelected");
            if(row){
                //清空数据
                purchasebillForm.form("clear");
                //把一些有data-hide的属性元素隐藏起来
                $("*[data-hide]").hide();
                //禁用密码框
                $("*[data-hide] input").validatebox("disable");
                //<input name="department.id">
                // 关连对象回显需要做的操作
                //单据修改，回显供应商和采购员
                if(row.supplier){
                   row["supplier.id"] = row.supplier.id;
                }
                if(row.buyer){
                    row["buyer.id"] = row.buyer.id;
                }
                //进行数据的回显(在清空后面)
                purchasebillForm.form("load",row);
                //弹出界面
                purchasebillDlg.dialog("center").dialog("open");
            }else{
                $.messager.alert('提示','请选择一条你要修改的数据!','info');
            }
        },
        search(){
            //拿到查询条件的值
            var params = searchForm.serializeObject();
            //根据查询的值刷新grid数据
            purchasebillGrid.datagrid("load",params);
        }
    };

    /***************************单据明细的js代码--->easyui扩展库*******************************************************/
    var dg = $("#itemsGrid"),
        defaultRow = { product: "", productColor: "", productImage: "", num: "", price: "", amount: "", descs: "" },
        insertPosition = "bottom";

    var dgInit = function () {

        var getColumns = function () {
            var result = [];

            var normal = [
                {
                    field: 'product', title: '产品', width: 180,
                    //编辑器类型
                    editor: {
                        //下拉框类型
                        type: "combobox",
                        options: {
                            required: true,
                            valueField:'id',
                            textField:'name',
                            url:'/util/products',
                            panelHeight:'auto'
                        }
                    },
                    //下拉框展示的是产品的名称
                    formatter:function (v,r,i) {
                        return v?v.name:"";
                    }
                },
                {
                    field: 'productColor', title: '产品颜色', width: 180,

                    //展示产品颜色的操作
                    formatter:function (v,r,i) {
                        if (r && r.product){
                            return `<div style='width:20px;height:20px;background-color: ${r.product.color};'></div>`;
                            //return "<div style='width: 20px;height: 30px;background-color: '+r.product.color+''></div>"
                        }
                        return "";

                    }
                },
                {
                    field: 'num', title: '数量', width: 100,
                    editor: {
                        //只能输入数字类型
                        type: "numberbox",
                        options: {
                            required: true,
                            //支持小数点，2位精度
                            precision:2
                        }
                    }
                },
                {
                    field: 'price', title: '价格', width: 100,
                    editor: {
                        type: "numberbox",
                        options: {
                            required: true,
                            precision:2
                        }
                    }
                },
                {
                    field: 'amount', title: '小计', width: 100,
                    //小计等于数量乘以价格
                    formatter:function (v,r,i) {
                        if (r.num && r.price){
                            //小计的价格保留两位小数
                            return (r.num * r.price).toFixed(2);
                        }
                        return 0;
                    }
                },
                {
                    field: 'descs', title: '产品描述', width: 100,
                    editor: {
                        type: "numberbox",
                        options: {
                            rrequired: true
                        }
                    }
                }
            ];
            result.push(normal);

            return result;
        };
        var options = {
            idField: "ID",
            rownumbers: true,
            fitColumns: true,
            fit: true,
            //加上边框
            border: true,
            //添加，修改的工具栏
            toolbar:"#itemsGridToolBar",
            height:400,
            singleSelect: true,
            columns: getColumns(),
            //表示开启单元格编辑功能
            enableCellEdit: true
        };

        dg.datagrid(options);

    };

    var getInsertRowIndex = function () {
        return insertPosition == "top" ? 0 : dg.datagrid("getRows").length;
    }

    //按钮数据绑定
    var buttonBindEvent = function () {

        //对应purchasebill.jsp里添加的按钮
        $("#btnInsert").click(function () {
            var targetIndex = getInsertRowIndex(), targetRow = $.extend({}, defaultRow, { ID: $.util.guid() });
            dg.datagrid("insertRow", { index: targetIndex, row: targetRow });
            //编辑行的数据，index-第几行，field-第几列
            dg.datagrid("editCell", { index: targetIndex, field: "product" });
        });
    };


    dgInit(); buttonBindEvent();


})