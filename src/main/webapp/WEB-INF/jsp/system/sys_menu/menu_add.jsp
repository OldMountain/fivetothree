<%--
  menu_add
  User: luhangqi
  Date: 2018/10/31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form" lay-filter="form-menu-edit">
            <div class="layui-form-item">
                <label class="layui-form-label">上级菜单</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" style="color: #FF5722;" readonly value="${menu.menuName}">
                    <%--<label class="layui-form-label">${menu.menuName ? menu.menuName : "全部菜单"}</label>--%>
                    <input type="hidden" name="parentId" value="${menu.menuId}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜单名称</label>
                <div class="layui-input-block">
                    <input type="text" name="menuName" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜单URL</label>
                <div class="layui-input-block">
                    <input type="text" name="menuUrl" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">图标</label>
                <div class="layui-input-block">
                    <input type="text" name="menuIcon" placeholder="请输入" autocomplete="off" class="layui-input">
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
<script src="${ctx}static/js/menu/menu_add.js"></script>
