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
        reloadUpTable: function (tableId) {
            if (!tableId) {
                tableId = $("table.layui-table").prop('id');
            }
            parent.table.reload($("table.layui-table").prop('id'));
        },
        loadMenuStatus: function () {
            var layHref = window.location.hash;
            layHref = layHref.substring(2);
            $("#LAY-system-side-menu").find("a[lay-href='" + layHref + "']").parent().addClass("layui-this");
            $("#LAY-system-side-menu").find("a[lay-href='" + layHref + "']").parents("li").addClass("layui-nav-itemed");
        }
    };

    //输出test接口
    exports('tool', obj);
});