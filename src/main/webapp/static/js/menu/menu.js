var table;
layui.use(['index', 'form', 'upload', 'table'], function () {
    table = layui.table //表格
    var zTree;
    getTree(layui.cache.root + "menu/getMenuTree", $("#treeBox"))
    $("#menu-add").click(function () {
        openAdd();
    });

    var meuCols = [ //表头
        {type: 'checkbox', fixed: 'left'}
        , {field: 'menuId', title: 'ID', sort: true, width: 80}
        , {field: 'menuName', title: '菜单名称'}
        , {field: 'menuUrl', title: '菜单URL', sort: true}
        , {field: 'parentName', title: '上级菜单', sort: true}
        , {field: 'menuOrder', title: '序号', sort: true}
        , {field: 'menuIcon', title: '图标'}
        , {field: 'menuType', title: '菜单类型'}
    ];

    var permissionCols = [ //表头
        {type: 'checkbox', fixed: 'left'}
        , {field: 'id', title: 'ID', sort: true, width: 80}
        , {field: 'name', title: '权限名称'}
        , {field: 'permission', title: '权限值', sort: true}
        , {field: 'menuName', title: '所属菜单', sort: true}
        , {hide: true}
        , {hide: true}
        , {hide: true}
    ];

    table.render({
        elem: '#menu-table'
        , id: 'menuTable'
        , height: 420
        , url: layui.cache.root + 'menu/getSubMenu?menuId=0' //数据接口
        , title: '用户表'
        , page: true //开启分页
        , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        , totalRow: false //开启合计行
        , cols: [//表头
            meuCols
        ]
    });

    table.on('toolbar(menu-table)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                openAdd();
                break;
            case 'update':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if (data.length > 1) {
                    layer.msg('只能同时编辑一个');
                } else {
                    layer.alert('编辑 [id]：' + checkStatus.data[0].menuId);
                }
                break;
            case 'delete':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    layer.msg('删除');
                }
                break;
        }
        ;
    })


    function onClick(event, treeId, treeNode) {
        zTree.checkNode(treeNode);
        var level = treeNode.level;
        if (level && level == 2) {
            console.info("level2 - > " + level)
            table.reload("menuTable", {
                url: layui.cache.root + 'menu/getPermissions?menuId=' + treeNode.id,
                cols: [permissionCols]
            })
            return;
        }
        console.info("level - > " + level)
        table.reload("menuTable", {
            url: layui.cache.root + 'menu/getSubMenu?menuId=' + treeNode.id,
            cols: [meuCols]
        })
    }

    function openAdd() {
        var nodes = zTree.getCheckedNodes(true);
        var menuId = '';
        var level;
        if (nodes && nodes.length > 0) {
            menuId = zTree.getCheckedNodes(true)[0].id;
            level = zTree.getCheckedNodes(true)[0].level;
        }
        var title = '添加一级菜单';
        if (!level) {
            level = 0;
        }
        if (level == 1) {
            title = '添加二级菜单';
        } else if (level == 2) {
            title = '添加按钮权限';
        }
        open("menu/toAdd", title, menuId, level);

    }

    function open(url, title, menuId, level) {
        layer.open({
            title: title,
            type: 2,
            area: ['700px', '450px'],
            fixed: false, //不固定
            maxmin: true,
            content: layui.cache.root + url + '?menuId=' + menuId + '&level=' + level
        });
    }


    function initTree(ele, nodes) {
        var setting = {
            view: {
                dblClickExpand: false
            },
            check: {
                enable: true,
                chkStyle: "radio",
                radioType: "all"
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                onClick: onClick
            }
        };
        zTree = $.fn.zTree.init(ele, setting, nodes);
    }

    function getTree(url, ele) {
        $.ajax({
            url: url,
            type: 'post',
            data: {},
            dataType: 'json',
            success: function (result) {
                initTree(ele, JSON.parse(result.data))
            }
        })
    }

});
