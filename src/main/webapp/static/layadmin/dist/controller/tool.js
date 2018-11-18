layui.define('table', function (exports) { //提示：模块也可以依赖其它模块，如：layui.define('layer', callback);
    // document.getElementsByClassName("");
    var $ = layui.$;
    var table = layui.table;
    var obj = {
        reloadTable: function (tableId) {
            if (!tableId) {
                tableId = $("table.layui-table").prop('id');
            }
            table.reload($("table.layui-table").prop('id'));
        },
        loadMenuStatus: function () {
            var path = layui.router().path
                , pathURL = layui.admin.correctRouter(path.join('/'))
                , dataName = layui.setter.response.dataName;
            layui.each($("#LAY-system-side-menu a"), function (index, item) {
                if (!path[0] && index == 0) {
                    classSelected(item);
                    return;
                } else if ($(item).attr("lay-href") && pathURL.startsWith(layui.admin.correctRouter($(item).attr("lay-href")))) {
                    classSelected(item);
                    return;
                }
            })
        }
    };

    var classSelected = function (item) {
        $(item).parent().addClass("layui-this");
        $(item).parents("li").addClass("layui-nav-itemed");
    }

    //输出test接口
    exports('tool', obj);
});