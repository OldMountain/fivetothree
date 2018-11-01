<%--
  menu_add
  User: luhangqi
  Date: 2018/10/31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <jsp:include page="${jspPath}/view/head.jsp"></jsp:include>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">父菜单</label>
                <div class="layui-input-block">
                    <input type="text" name="" class="layui-input layui-disabled" disabled value="ss">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜单名称</label>
                <div class="layui-input-block">
                    <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜单URL</label>
                <div class="layui-input-block">
                    <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">图标</label>
                <div class="layui-input-block">
                    <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-fluid">确认</button>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="${jspPath}/view/foot.jsp"></jsp:include>
<script>
    layui.use(['index', 'form', 'upload'], function () {

    });
</script>
</body>
</html>
