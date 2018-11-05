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
        <form class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">所属菜单</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" style="color: #FF5722;" readonly value="${menu.menuName}">
                    <%--<label class="layui-form-label">${menu.menuName ? menu.menuName : "全部菜单"}</label>--%>
                    <input type="hidden" name="menuId" value="${menu.menuId}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">权限名称</label>
                <div class="layui-input-block">
                    <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">权限值</label>
                <div class="layui-input-block">
                    <input type="text" name="permission" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="submitBtn">确认</button>
                </div>
            </div>
        </form>
    </div>
</div>
<jsp:include page="${jspPath}/view/foot.jsp"></jsp:include>
<script src="${ctx}static/js/menu/permission_add.js"></script>
</body>
</html>

