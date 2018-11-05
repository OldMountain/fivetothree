layui.use(['index', 'form'], function () {
    var form = layui.form;
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    //获取菜单ID
    form.on('submit(submitBtn)',function (data) {
        var params = data.field;
        savePermission(params);
        return false;
    })

    function savePermission(params) {
        $.ajax({
            url: layui.cache.root + "menu/savePermission",
            type: 'post',
            data: params,
            dataType: 'json',
            success: function (result) {
                if (result.code == 200) {
                    parent.layer.msg('保存成功');
                    parent.table.reload("menuTable", {
                        url: layui.cache.root + 'menu/getPermissions?menuId=' + $("#menuId").val()
                    })
                    parent.layer.close(index);
                }else {
                    parent.layer.alert(result.message);
                }
            }
        })
    }
});