<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <jsp:include page="${jspPath}/view/head.jsp"></jsp:include>
    <link type="text/css" rel="stylesheet" href="${ctx}plugins/ztree/zTreeStyle.css"/>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body" pad15>
                    <table id="role-table" class="layui-table" lay-filter="roleTable">

                    </table>
                    <script type="text/html" id="bar-role">
                        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="option">权限</a>
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<div>
    <div id="menu-tree" style="text-align: center;display: none">
        <ul id="treeBox" class="ztree" style="margin: 20px auto;width: 200px"></ul>
    </div>
</div>
<jsp:include page="${jspPath}/view/foot.jsp"></jsp:include>
<script src="${ctx}plugins/ztree/jquery.ztree.all.min.js" type="application/javascript"></script>
<script src="${ctx}static/js/role/role.js"></script>
</body>
</html>