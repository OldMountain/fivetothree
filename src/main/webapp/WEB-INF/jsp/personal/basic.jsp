<%--
  basic
  User: luhangqi
  Date: 2018/10/25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">设置我的资料</div>
                <div class="layui-card-body" pad15>

                    <form class="layui-form" lay-filter="" action="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">我的角色</label>
                            <div class="layui-input-inline">
                                <select name="role" lay-verify="">
                                    <option value="1" selected>超级管理员</option>
                                    <option value="2" disabled>普通管理员</option>
                                    <option value="3" disabled>审核员</option>
                                    <option value="4" disabled>编辑人员</option>
                                </select>
                            </div>
                            <div class="layui-form-mid layui-word-aux">当前角色不可更改为其它角色</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" value="${user.name}" readonly
                                       class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">不可修改。一般用于后台登入名</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">昵称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="nickname" value="${user.nick}" lay-verify="nickname"
                                       autocomplete="off" placeholder="请输入昵称" class="layui-input">
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
        </div>
    </div>
</div>
<script>
    layui.use(['index', 'form', 'upload'], function () {
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#LAY_avatarUpload' //绑定元素
            , url: '/upload/' //上传接口
            , done: function (res) {
                //上传完毕回调
            }
            , error: function () {
                //请求异常回调
            }
        });
    });
</script>
</body>
</html>
