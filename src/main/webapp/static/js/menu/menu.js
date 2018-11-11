layui.use(['index', 'form', 'upload', 'table','element','admin'], function () {
    var table = layui.table; //表格
    var element = parent.layui.element;
    var admin = layui.admin;
    var view = layui.view;
    var form = layui.form;
    var zTree;
    getTree(ctx + "menu/getMenuTree", $("#treeBox"))
    $("#menu-add").click(function () {
        openAdd();
    });

    $("#resetMenu").click(function () {
        resetMenu();
    })

    var meuCols = [ //表头
        {type: 'checkbox', fixed: 'left'}
        , {field: 'numbers', title: '序号', sort: true, width: 80, type: 'numbers'}
        , {field: 'menuName', title: '菜单名称'}
        , {field: 'menuUrl', title: '菜单URL', sort: true}
        , {field: 'parentName', title: '上级菜单', sort: true}
        , {field: 'menuOrder', title: '排序', sort: true}
        , {field: 'menuIcon', title: '图标'}
        , {field: 'menuType', title: '菜单类型'}
    ];

    var permissionCols = [ //表头
        {type: 'checkbox', fixed: 'left'}
        , {field: 'numbers', title: '序号', sort: true, width: 80, type: 'numbers'}
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
        , url: ctx + 'menu/getSubMenu?menuId=0' //数据接口
        , title: '用户表'
        , loading: true // 是否显示加载条
        , page: true //开启分页
        , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        , totalRow: false //开启合计行
        , title: '系统异常，请联系管理员'
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
        if (treeNode.checked) {
            return;
        }
        zTree.checkNode(treeNode, true);
        var level = treeNode.level;
        if (level && level == 2) {
            table.reload("menuTable", {
                url: ctx + 'menu/getPermissions?menuId=' + treeNode.id,
                cols: [permissionCols]
            })
            return;
        }
        table.reload("menuTable", {
            url: ctx + 'menu/getSubMenu?menuId=' + treeNode.id,
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
        // open("menu/toAdd", title, menuId, level);
        admin.popup({
            title: title
            ,area: ['500px', '450px']
            ,id: 'popup-menu'
            ,success: function(layero, index){
                view(this.id).render('menu/toAdd?menuId=' + menuId + '&level=' + level);
            }
        });
    }

    function open(url, title, menuId, level) {
        layer.open({
            title: title,
            type: 2,
            area: ['700px', '450px'],
            fixed: false, //不固定
            maxmin: true,
            content: ctx + url + '?menuId=' + menuId + '&level=' + level
        });
    }


    function initTree(ele, nodes) {
        var setting = {
            view: {
                dblClickExpand: true
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
                onClick: onClick,
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

    function resetMenu() {
        $.ajax({
            url: ctx + 'menu/reset',
            type: 'post',
            data: {},
            success: function (result) {
                if (result.code == 200) {
                    layer.msg('保存成功');
                    parent.window.location.reload();
                } else {
                    layer.alert(result.message);
                }
            }
        })
    }

});
