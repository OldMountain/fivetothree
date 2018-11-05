layui.use(['index', 'form'], function () {
    var form = layui.form;
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
    //获取菜单ID
    form.on('submit(submitBtn)',function (data) {
        var params = data.field;
        saveMenu(params);
        return false;
    })

    function saveMenu(params) {
        $.ajax({
            url: layui.cache.root + "menu/save",
            type: 'post',
            data: params,
            dataType: 'json',
            success: function (result) {
                if (result.code == 200) {
                    layer.msg('保存成功');
                }else {
                    layer.alert(result.message);
                }
            }
        })
    }
});