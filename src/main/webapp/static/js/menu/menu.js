layui.use(['index', 'form', 'upload', 'table'], function () {
    var table = layui.table //表格
    getTree(layui.cache.root + "menu/getMenuTree", $("#treeBox"))
    $("#menu-add").click(function () {
        layer.open({
            title: '菜单管理',
            type: 2,
            area: ['700px', '450px'],
            fixed: false, //不固定
            maxmin: true,
            content: layui.cache.root + 'menu/toAdd'
        });
    });

    table.render({
        elem: '#menu-table'
        , id: 'menuTable'
        , height: 420
        , url: layui.cache.root + 'menu/getSubMenu?menuId=0' //数据接口
        , title: '用户表'
        , page: true //开启分页
        , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        , totalRow: false //开启合计行
        , cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            , {field: 'menuId', title: 'ID', sort: true}
            , {field: 'menuName', title: '菜单名称'}
            , {field: 'menuUrl', title: '菜单URL', sort: true}
            , {field: 'parentId', title: '上级菜单ID', sort: true}
            , {field: 'menuOrder', title: '序号', sort: true}
            , {field: 'menuIcon', title: '图标'}
            , {field: 'menuType', title: '菜单类型'}
        ]]
    });


    function onClick(event, treeId, treeNode) {
        zTree.checkNode(treeNode);
        table.reload("menuTable",{
            url: layui.cache.root + 'menu/getSubMenu?menuId=' + treeNode.id
        })
    }


    var zTree;

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
