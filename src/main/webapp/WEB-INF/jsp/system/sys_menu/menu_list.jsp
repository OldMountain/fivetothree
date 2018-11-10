<%--
  menu_list
  User: luhangqi
  Date: 2018/10/28
--%>
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
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-body" pad15>
                    <section>
                        <div class="" style="text-align: center">
                            <ul id="treeBox" class="ztree"></ul>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <div class="layui-col-md10">
            <div class="layui-card layui-form">
                <div class="layui-card-header" pad15>
                    <button id="resetMenu" class="layui-btn layui-btn-normal">重置左侧菜单列表</button>
                </div>
                <div class="layui-card-body" pad15>
                    <table class="layui-table" id="menu-table" lay-filter="menu-table">

                    </table>

                    <script type="text/html" id="barDemo">
                        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="${jspPath}/view/foot.jsp"></jsp:include>
<script src="${ctx}plugins/ztree/jquery.ztree.all.min.js" type="application/javascript"></script>
<script src="${ctx}static/js/menu/menu.js" type="application/javascript"></script>
</body>
</html>
