layui.use(['index', 'form', 'table'], function () {
    var table = layui.table;
    var roleCols = [
        {type: 'checkbox', fixed: 'left'}
        , {field: 'numbers', title: '序号', sort: true, width: 80, type: 'numbers'}
        , {field: 'roleId', title: '角色ID', hide: true}
        , {field: 'roleName', title: '角色名称'}
        , {field: 'desc', title: '职责描述'}
    ];
    table.render({
        elem: '#role-table'
        , id: 'roleTable'
        , height: 420
        , url: layui.cache.root + 'role/getData' //数据接口
        , title: '用户表'
        , loading: true // 是否显示加载条
        , page: true //开启分页
        , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        , totalRow: false //开启合计行
        , title: '系统异常，请联系管理员'
        , cols: [//表头
            roleCols
        ]
    });
});