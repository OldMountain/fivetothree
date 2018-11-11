<%--
  menu_add
  User: luhangqi
  Date: 2018/10/31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-fluid">
	<div class="layui-row">
		<form class="layui-form">
			<div class="layui-form-item">
					<input type="hidden" name="parentId" value="0">
					<input type="hidden" name="roleId" value="${role.roleId != null ? role.roleId:''}">
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">角色名称</label>
				<div class="layui-input-block">
					<input type="text" name="roleName" value="${role.roleName != null ? role.roleName:''}" placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="required">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">描述</label>
				<div class="layui-input-block">
					<textarea name="desc" placeholder="请输入内容" class="layui-textarea">${role.desc != null ? role.desc:''}</textarea>
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
<script src="${ctx}static/js/role/role_add.js"></script>
