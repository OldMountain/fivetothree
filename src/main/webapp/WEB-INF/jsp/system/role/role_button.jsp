<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<link type="text/css" rel="stylesheet" href="plugins/zTree/2.6/zTreeStyle.css"/>


<div>
    <ul id="tree" class="tree" style="overflow:auto;"></ul>
</div>
<div style="text-align: center">
    <a class="btn btn-mini btn-primary" onclick="save();">保存</a>
    <a class="btn btn-mini btn-danger" onclick="$.closeModal();">关闭</a>
</div>


<script type="text/javascript">
    var zTree;
    $(document).ready(function () {

        var setting = {
            showLine: true,
            checkable: true,
            showIcon: false
        };
        var zn = '${zTreeNodes}';
        var zTreeNodes = eval(zn);
        zTree = $("#tree").zTree(setting, zTreeNodes);
    });

    function save() {

        var nodes = zTree.getCheckedNodes();
        var tmpNode;
        var ids = "";
        for (var i = 0; i < nodes.length; i++) {
            tmpNode = nodes[i];
            if (i != nodes.length - 1) {
                ids += tmpNode.id + ",";
            } else {
                ids += tmpNode.id;
            }
        }

        var roleId = "${roleId}";
        var msg = "${msg}";
        var url = "<%=basePath%>role/roleButton/save.do";
        var postData;

        postData = {"ROLE_ID": roleId, "menuIds": ids, "msg": msg};

        $.post(url, postData, function (data) {
            //if(data && data=="success"){
            $.closeModal();
            //}
        });

    }
</script>
