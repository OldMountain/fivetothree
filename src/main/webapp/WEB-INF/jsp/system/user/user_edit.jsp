<%--
  menu_add
  User: luhangqi
  Date: 2018/11/10
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">
            <div class="layui-form-item">
                <input type="hidden" name="userId" value="${user.userId != null ? user.userId:''}">
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">角色</label>
                <div class="layui-input-block">
                    <input type="text" name="roleId" value="${user.roleId != null ? user.roleId:''}" placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="required">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">用户账户</label>
                <div class="layui-input-block">
                    <input type="text" name="userName" value="${user.userName != null ? user.userName:''}" placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="required">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">昵称</label>
                <div class="layui-input-block">
                    <input type="text" name="nick" value="${user.nick != null ? user.nick:''}" placeholder="请输入" autocomplete="off" class="layui-input" lay-verify="required">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block">
                    <input type="radio" name="sex" value="男"
                           title="男" ${ !user.sex || user.sex == 1 ? "checked":""}>
                    <input type="radio" name="sex" value="女" title="女" ${user.sex == 2 ? "checked":""}>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">头像</label>
                <div class="layui-input-inline">
                    <input name="avatar" lay-verify="required" id="LAY_avatarSrc" placeholder="图片地址"
                           value="http://cdn.layui.com/avatar/168.jpg" class="layui-input">
                </div>
                <div class="layui-input-inline layui-btn-container" style="width: auto;position: relative">
                    <button type="button" class="layui-btn layui-btn-primary" id="LAY_avatarUpload">
                        <i class="layui-icon">&#xe67c;</i>上传图片
                    </button>
                    <div style="position: absolute;left: 150px;bottom: 10px;">
                        <img src="http://cdn.layui.com/avatar/168.jpg" alt="" class="layui-circle"/>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">手机</label>
                <div class="layui-input-inline">
                    <input type="text" name="cellphone" value="${user.phone}" lay-verify="phone"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">邮箱</label>
                <div class="layui-input-inline">
                    <input type="text" name="email" value="${user.email}" lay-verify="email"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">个性签名</label>
                <div class="layui-input-block">
                                <textarea name="remarks" placeholder="请输入内容"
                                          class="layui-textarea">${user.sign}</textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="setmyinfo">确认修改</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重新填写</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="${ctx}static/js/user/user_add.js"></script>