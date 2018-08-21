<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<script type="text/javascript">
    $(document).ready(function () {
        if ($("#userId").val() != "") {
            $("#userName").attr("readonly", "readonly");
            $("#userName").css("color", "gray");
        }


//        /*校验*/
        var hasSubmit = true;
        $("#userForm").validate($.validateUtil.config({
                roleId: {required: true}
                , userName: {
                    required: true,
                    remote: {
                        url: "user/hasUserName.do"
                        , type: "get"
                        , dataType: "json"
                        , data: {userId: $("#userId").val()}//附加参数
                    }
                }
//                , number: {
//                    required: true, remote: {
//                        url: "user/hasN.do"
//                        , type: "get"
//                        , dataType: "json"
//                        , data: {userId: $("#userId").val()}//附加参数
//                    }
//                }
                , password: {required: ${msg == 'edit'?false:true }}
                , chkpwd: {required: ${msg == 'edit'?false:true }, equalTo: "#password"}
                , userId: {required: true}
                , name: {required: true}
                , phone: {required: true, phone: true}
            },
            function (form) {
                if (hasSubmit) {
                    hasSubmit = false;
                    $(form).ajaxSubmit({
                        type: 'post', success: function (data) {
                            hasSubmit = true;
                            if (data) {
                                swalAlert("保存成功");
                                $.closeModal();
                            } else {
                                swalAlert("保存失败",swalIcon.WARNING);
                            }
                        }
                    })
                } else {
                    swalAlert("请勿重复提交",swalIcon.WARNING);
                }
            }, {
                chkpwd: {
                    equalTo: "两次输入密码不一致"
                },
                email: {
                    remote: "该邮箱已被使用"
                },
                number: {
                    remote: "编号已经存在"
                },
                userName: {
                    remote: "用户名已被占用"
                }
            }));

    });


</script>

<form action="user/${msg }.do" name="userForm" id="userForm" method="post" role="form" class="form-horizontal"
      style="margin: 0 20px">
    <input type="hidden" name="userId" id="userId" value="${user.userId }"/>

    <%--<c:if test="${fx != 'head'}">--%>
    <c:if test="${roleEdit == '1'}">

        <div class="form-group">
            <label class="col-sm-3">请选择角色</label>
            <div class="col-sm-9 ftt-select">
                <select class="form-control" name="roleId" id="roleId" data-placeholder="请选择职位">
                    <c:forEach items="${roleList}" var="role">
                        <option value="${role.roleId }"
                                <c:if test="${user != null && role.roleId == user.roleId }">selected</c:if>>${role.roleName }</option>
                    </c:forEach>
                </select></div>
        </div>
    </c:if>
    <c:if test="${roleEdit == '0'}">
        <input name="roleId" id="roleId" value="${user.roleId}" type="hidden"/>
    </c:if>
    <%--</c:if>--%>
    <%--<c:if test="${fx == 'head'}">--%>
    <%--<input name="roleId" id="roleId" value="${user.roleId }" type="hidden"/>--%>
    <%--</c:if>--%>

    <div class="form-group">
        <label for="userName" class="col-sm-3">用户名</label>
        <div class="col-sm-9">
            <input type="text" name="userName" id="userName" value="${user.userName }" maxlength="32" placeholder="用户名"
                   class="form-control"/></div>
    </div>

    <div class="form-group">
        <label class="col-sm-3">编号</label>
        <div class="col-sm-9">
            <input type="text" name="number" id="number" value="${user.number }" maxlength="32" placeholder="这里输入编号"
                   class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3">密码</label>
        <div class="col-sm-9">
            <input type="password" name="password" id="password" maxlength="16" placeholder="密码" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3">确认密码</label>
        <div class="col-sm-9">
            <input type="password" name="chkpwd" id="chkpwd" maxlength="16" placeholder="确认密码" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3">姓名</label>
        <div class="col-sm-9">
            <input type="text" name="name" id="name" value="${user.name }" maxlength="32" placeholder="这里输入姓名"
                   class="form-control"/></div>
    </div>

    <div class="form-group">
        <label class="col-sm-3">手机号</label>
        <div class="col-sm-9">
            <input type="tel" name="phone" id="phone" value="${user.phone }" maxlength="32" placeholder="这里输入手机号"
                   class="form-control"/></div>
    </div>

    <div class="form-group">
        <label class="col-sm-3">邮箱</label>
        <div class="col-sm-9">
            <input type="email" name="email" id="email" value="${user.email }" maxlength="32" placeholder="这里输入邮箱"
                   class="form-control"/></div>
    </div>

    <div class="form-group">
        <label class="col-sm-3">备注</label>
        <div class="col-sm-9">
        <textarea name="bz" id="bz" style="max-width: 100%;min-height: 100px;" placeholder="这里输入备注" maxlength="64"
                  class="form-control">${user.bz }</textarea></div>
        <%--<input type="text" name="bz" id="bz" value="${user.bz }" placeholder="这里输入备注" maxlength="64"--%>
        <%--class="form-control"/>--%>
    </div>

    <%--<div style="text-align: center">--%>
    <%--<input class="btn btn-primary" type="submit" value="保存"/>--%>
    <%--<a class="btn btn-danger" onclick="$.closeModal();">关闭</a>--%>
    <%--</div>--%>
    <c:if test="${QX.add == 1}">
        <input class="btn btn-primary" type="submit" value="保存"/>
        <a class="btn btn-danger" onclick="$.closeModal();">关闭</a>
    </c:if>
    <c:if test="${QX.add == 0}">
        <div>
            您没有权限新增
        </div>
    </c:if>
</form>