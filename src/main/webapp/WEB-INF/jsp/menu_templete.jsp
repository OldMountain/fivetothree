<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="plugins/ztree/zTreeStyle.css"/>
<section>
    <div class="" style="text-align: center">
        <ul id="treeBox" class="ztree"></ul>
    </div>
    <div style="text-align: center">
        <a class="btn btn-mini btn-primary" onclick="save();">保存</a>
        <a class="btn btn-mini btn-danger" onclick="$.closeModal();">关闭</a>
    </div>
</section>
<script type="text/javascript">
    var zTree;
    var setting = {
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };

    var zNodes =${treeNode};

    var code;

    function setCheck() {
        var zTree = $.fn.zTree.getZTreeObj("treeBox"),
            py = $("#py").attr("checked") ? "p" : "",
            sy = $("#sy").attr("checked") ? "s" : "",
            pn = $("#pn").attr("checked") ? "p" : "",
            sn = $("#sn").attr("checked") ? "s" : "",
            type = {"Y": py + sy, "N": pn + sn};
        zTree.setting.check.chkboxType = {"Y": "ps", "N": "ps"};
        showCode('setting.check.chkboxType = { "Y" : "' + type.N + '", "N" : "' + type.N + '" };');
    }

    function showCode(str) {
        if (!code) code = $("#code");
        code.empty();
        code.append("<li>" + str + "</li>");
    }

    $(document).ready(function () {
        zTree = $.fn.zTree.init($("#treeBox"), setting, zNodes);
        setCheck();
        $("#py").bind("change", setCheck);
        $("#sy").bind("change", setCheck);
        $("#pn").bind("change", setCheck);
        $("#sn").bind("change", setCheck);
    });

    function save() {
        var ids = '';
        var nodes = zTree.getCheckedNodes();
        for (var i = 0; i < nodes.length; i++) {
            if (ids != '') {
                ids += "," + nodes[i].id;
            } else {
                ids += nodes[i].id;
            }
        }
        console.info("——" + ids)
        var data = {
            ids: ids,
        };
        var params = '(${params})';
        if(params){
            params = eval(params);
            for(var i in params){
                console.info("params循环——" + params[i])
                data[i] = params[i];
            }
        }
        $.ajax({
            url: '${url}',
            type: 'post',
            dataTyp: 'json',
            data: data,
            success: function (data) {
                $.closeModal();
                if(data.status != 'success'){
                    swal(data.message,"","error");
                }
            }
        })
    }
</script>