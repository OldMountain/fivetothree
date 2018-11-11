layui.use(['index', 'form', 'table', 'tool','element','admin'], function () {
    var table = layui.table;
    var tool = layui.tool;
    var element = layui.element;
    var admin = layui.admin;
    var roleCols = [
        {type: 'checkbox', fixed: 'left'}
        , {field: 'numbers', title: '序号', sort: true, width: 80, type: 'numbers'}
        , {field: 'userId', title: '用户ID', hide: true}
        , {field: 'userName', title: '用户名'}
        , {field: 'phone', title: '手机'}
        , {field: 'email', title: '邮箱'}
        , {field: 'nick', title: '昵称'}
        , {field: 'age', title: '年龄'}
        , {field: 'sex', title: '性别'}
        , {fixed: 'right', title: '操作', toolbar: '#fttBar', width: 250}
    ];
    table.render({
        elem: '#fttTable'
        , height: 420
        , url: ctx + 'user/getData' //数据接口
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

    //监听行工具事件
    table.on('tool(fttTable)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'option') {
            layer.open({
                type: 1,
                title: "添加权限",
                closeBtn: 0,
                shadeClose: true,
                area: '400px', //宽高
                offset: '10%',
                content: $("#menu-tree")
                , btn: ['确定', '取消']
                , yes: function (index, layero) {
                    save(data.roleId);
                    layer.close(index)
                }
                , btn2: function (index, layero) {

                }
                , btnAlign: 'c'
            });
            getMenu(ctx + "menu/getPermissionsTree?userId=" + data.userId, $("#indexTreeBox"));
        }
    });

    table.on('toolbar(fttTable)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                // element.tabChange('layadmin-layout-tabs', 'console');
                open("user/toAdd");
                break;
            case 'update':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if (data.length > 1) {
                    layer.msg('只能同时编辑一个');
                } else {
                    open("user/toModify?userId=" + data[0].userId);
                }
                break;
            case 'delete':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    layer.confirm('是否删除用户<span style="color: red">【' + data[0].userName + '】</span>?', function (index) {
                        $.ajax({
                            url: ctx + 'user/remove',
                            type: 'post',
                            data: {roleId: data[0].userId},
                            success: function (result) {
                                if (result.code == 200) {
                                    tool.reloadTable();
                                } else {
                                    layer.alert(result.message);
                                }
                            }
                        })
                        layer.close(index);
                    });
                }
                break;
        }
        ;
    })

    function open(url) {
        layer.open({
            title: '新增用户',
            type: 2,
            area: ['700px', '450px'],
            fixed: false, //不固定
            maxmin: true,
            content: ctx + url
        });
    }

    var zTree;

    function save(userId) {
        var nodes = zTree.getCheckedNodes(true);
        var permissions = '';
        var menuIds = '';
        for (var i = 0; i < nodes.length; i++) {
            if (nodes[i].level == 0) {
                continue;
            }
            if (nodes[i].type == 'menu') {
                menuIds += nodes[i].id + ',';
            } else {
                permissions += nodes[i].id + ',';
            }
        }
        var params = {
            userId: userId,
            permissions: permissions,
            menuIds: menuIds
        };
        $.ajax({
            url: ctx + 'user/saveUserPermission',
            type: 'post',
            data: params,
            dataType: 'json',
            success: function (result) {

            }
        })
    }

    function getMenu(url, ele) {
        $.ajax({
            url: url,
            type: 'post',
            data: {},
            dataType: 'json',
            success: function (result) {
                initTree(ele, result.data)
            }
        })
    }


    function initTree(ele, nodes) {
        var setting = {
            view: {
                dblClickExpand: true
            },
            check: {
                enable: true,
                radioType: "all"
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };
        zTree = $.fn.zTree.init(ele, setting, nodes);
        zTree.expandAll(true)
        var nodes = zTree.getCheckedNodes(true);
        for (var i = 0; i < nodes.length; i++) {
            zTree.updateNode(nodes[i], true)
        }
    }

});