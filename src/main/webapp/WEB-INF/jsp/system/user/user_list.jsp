<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<style>
</style>

<section class="content">
    <div class="row">
        <div class="col-xs-12">
            <div class="box box-primary">
                <div class="box-body">
                    <%--<a class="btn btn-info" onclick="editRights('${pd.ROLE_ID }');"><i class="icon-pencil"></i>组菜单权限</a>--%>
                    <span>用户管理</span>
                    <p></p>
                    <div class="row">
                        <div class="col-sm-12">
                            <table class="table table-bordered dataTable">
                                <thead>
                                <tr role="row">
                                    <th>
                                        <div class="ftt-checkbox">
                                            <label for="checkAll">
                                                <input type="checkbox" name="checkAll" id="checkAll" data-child="checkbox-userid">
                                                <i style="font-size: 16px;"></i>
                                            </label>
                                        </div>
                                    </th>
                                    <th class="center col-xs-1" style="width: 10%">
                                        序号
                                    </th>
                                    <th>编号</th>
                                    <th class="center">用户名</th>
                                    <%--<th class="center">密码</th>--%>
                                    <th class="center">职位</th>
                                    <th class="center">最近登录</th>
                                    <th class="center">登录ip</th>
                                    <th class="col-xs-2" style="width: 20%">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="user" items="${userList}" varStatus="status">
                                    <tr>
                                        <td>
                                            <div class="ftt-checkbox">
                                                <label for="check-user-${status.index+1}">
                                                    <input type="checkbox" name="checkbox-userid" id="check-user-${status.index+1}" value="${user.userId}">
                                                    <i style="font-size: 16px;"></i>
                                                </label>
                                            </div>
                                        </td>
                                        <td>${status.index+1}</td>
                                        <td>${user.number}</td>
                                        <td>${user.userName}</td>
                                            <%--<td>${user.password}</td>--%>
                                        <td>${user.roleName}</td>
                                        <td>${user.lastLogin}</td>
                                        <td>${user.ip}</td>
                                        <td>
                                            <a class="btn nxd-green" onclick="editUser('${user.userId}')">编辑</a>
                                            <a class="btn nxd-red" onclick="removeUser('${user.userId}')">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3">
                            <%--<c:if test="${QX.add == 1}">--%>
                            <a class="btn nxd-light-blue nxd-long" onclick="addUser();"
                               style="margin-right: 5px;">新增</a>
                            <a class="btn nxd-red nxd-long" onclick="batchRemoveUser();">批量删除</a>
                            <%--</c:if>--%>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="view-img">
    <img width="80px" src="static/images/bg.jpg">
    <img src="static/images/avtar.jpg">
</div>
<script id="nameTemp" type="text/html">
    {{userName}}<i class="iconftt icon-edit1 nxd-cursor" onclick="editName('{{userId}}',this,'{{userName}}')"></i>
</script>
<script id="editName" type="text/html">
    <input id='userName{{userId}}' type='text' class='nxd-input'/>
    <i class='iconftt icon-wancheng nxd-cursor' onclick='saveName("{{userId}}","{{userName}}")'></i>
</script>
<jsp:include page="../admin/modal.jsp" />
<script>
    $(function () {
        initImg();
    })
    //新增用户
    function addUser() {
        $.OpenModal({
            url: '<%=basePath%>user/toAdd'
            , width: 500
            , title: "新增用户"
            , onHidden: function () {
                // $.loadViewOrModal();
            }
        });
    }


    //编辑用户
    function editUser(userId) {
        $.OpenModal({
            url: '<%=basePath%>user/toEdit.do?userId=' + userId
            , width: 500
            , title: "编辑用户"
            , onHidden: function () {
                // $.loadViewOrModal();
            }
        });
    }

    //删除用户
    function removeUser(userId) {
        var params = {
            userId : userId
        };
        swalConfirm({
            icon: swalIcon.WARNING,
            OK:function () {
                $.ajax({
                    url: 'user/removeUser',
                    type: 'post',
                    data: params,
                    dataType: 'json',
                    success: function (result) {
                        $.loadViewOrModal("");
                    }
                })
            }
        })
    }

    //批量删除
    function batchRemoveUser() {
        var userIds = "";
        $("input[name='checkbox-userid']:checked").each(function () {
            if(userIds){
                userIds += "," + $(this).val();
            }else{
                userIds += $(this).val();
            }
        })
        var params = {
            userIds : userIds
        };
        $.ajax({
            url: 'user/batchRemoveUser.do',
            type: 'post',
            data: params,
            dataType: 'json',
            success: function (result) {
                $.loadViewOrModal();
            }
        })
    }

</script>

