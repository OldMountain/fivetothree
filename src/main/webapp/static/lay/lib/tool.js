layui.define('table', function (exports) { //提示：模块也可以依赖其它模块，如：layui.define('layer', callback);
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
        }
    };

    //输出test接口
    exports('tool', obj);
});