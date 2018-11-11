layui.use(['index', 'form'], function () {
    console.info("加载menu_add.js")
    var form = layui.form;
    //获取菜单ID
    form.on('submit(submitBtn)',function (data) {
        var params = data.field;
        saveMenu(params);
        return false;
    })

    function saveMenu(params) {
        $.ajax({
            url: ctx + "menu/save",
            type: 'post',
            data: params,
            dataType: 'json',
            success: function (result) {
                if (result.code == 200) {
                    layer.msg('保存成功');
                    layui.table.reload("menuTable")
                    layer.closeAll();
                }else {
                    layer.alert(result.message);
                }
            }
        })
    }
});