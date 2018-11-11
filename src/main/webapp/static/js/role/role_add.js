layui.use(['index', 'form'], function () {
    var form = layui.form;
    //获取菜单ID
    form.on('submit(submitBtn)',function (data) {
        var params = data.field;
        var url = 'role/save';
        if (params.roleId) {
            url = 'role/modify';
        }
        saveRole(params,url);
        return false;
    })

    function saveRole(params,url) {
        $.ajax({
            url: ctx + url,
            type: 'post',
            data: params,
            dataType: 'json',
            success: function (result) {
                if (result.code == 200) {
                    layer.msg('保存成功');
                    layui.table.reload("role-table")
                    layer.closeAll();
                }else {
                    layer.alert(result.message);
                }
            }
        })
    }
});