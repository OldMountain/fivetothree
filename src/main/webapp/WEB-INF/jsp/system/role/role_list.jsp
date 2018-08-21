<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<style>
    .juzhong {
        text-align: center;
    }
</style>


<section class="content">
    <div class="row">
        <div class="col-xs-12">
            <div class="box box-primary">
                <div class="box-body">
                    <%--<a class="btn btn-info" onclick="editRights('${pd.ROLE_ID }');"><i class="icon-pencil"></i>组菜单权限</a>--%>
                    <span>用户权限管理</span>
                    <p></p>
                    <div class="row">
                        <div class="col-sm-12">
                            <table class="table table-bordered dataTable">
                                <thead>
                                <tr role="row">
                                    <%--<th>--%>
                                    <%--<div class="nxd-checkbox">--%>
                                    <%--<input type="checkbox" id="checkAll"><label for="checkAll"></label>--%>
                                    <%--</div>--%>
                                    <%--</th>--%>
                                    <th class="center col-xs-1" style="width: 10%">
                                        序号
                                    </th>
                                    <th class="col-xs-5">角色</th>
                                    <th class="center col-xs-1">增</th>
                                    <th class="center col-xs-1">删</th>
                                    <th class="center col-xs-1">改</th>
                                    <th class="center col-xs-1">查</th>
                                    <th class="col-xs-2" style="width: 20%">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="role" items="${roleList}" varStatus="status">
                                    <tr>
                                            <%--<td>--%>
                                            <%--<div class="nxd-checkbox">--%>
                                            <%--<input id="check-role-${status.index+1}" type="checkbox"--%>
                                            <%--value="${role.roleId}">--%>
                                            <%--<label for="check-role-${status.index+1}"></label>--%>
                                            <%--</div>--%>
                                            <%--</td>--%>
                                        <td>${status.index+1}</td>
                                        <td>${role.roleName}<i class="iconftt icon-edit1 nxd-cursor"
                                                               onclick="editName('${role.roleId}',this,'${role.roleName}')"></i>
                                        </td>
                                        <td><a class="btn nxd-yellow" onclick="buttonRights('${role.roleId}','1')"><i
                                                class="icon-peizhi"></i></a></td>
                                        <td><a class="btn nxd-yellow" onclick="buttonRights('${role.roleId}','2')"><i
                                                class="icon-peizhi"></i></a></td>
                                        <td><a class="btn nxd-yellow" onclick="buttonRights('${role.roleId}','3')"><i
                                                class="icon-peizhi"></i></a></td>
                                        <td><a class="btn nxd-yellow" onclick="buttonRights('${role.roleId}','4')"><i
                                                class="icon-peizhi"></i></a></td>
                                        <td>
                                            <a class="btn nxd-blue" onclick="editRights('${role.roleId}')">菜单权限</a>
                                            <a class="btn nxd-red" onclick="removeRole('${role.roleId}')">删除</a>
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
                            <a class="btn nxd-light-blue nxd-long" onclick="addRole2('${role.parentId }');">新增</a>
                            <%--</c:if>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script id="nameTemp" type="text/html">
    {{roleName}}<i class="iconftt icon-edit1 nxd-cursor" onclick="editName('{{roleId}}',this,'{{roleName}}')"></i>
</script>
<script id="editName" type="text/html">
    <input id='roleName{{roleId}}' type='text' class='nxd-input'/>
    <i class='iconftt icon-wancheng nxd-cursor' onclick='saveName("{{roleId}}","{{roleName}}")'></i>
</script>
<script>
    //新增角色
    function addRole2(pid) {
        $.OpenModal({
            url: '<%=basePath%>role/toAdd.do?parentId=' + pid
//            body: '22222'
            , width: 500
            , title: "新增角色"
            , onHidden: function () {
                // $.loadViewOrModal();
            }
        });
    }

    //菜单权限
    function editRights(roleId) {

        $.OpenModal({
            url: '<%=basePath%>role/auth.modal?roleId=' + roleId
            , width: 500
            , title: "菜单权限"
        });
    }

    //菜单操作权限
    function buttonRights(roleId, type) {

        $.OpenModal({
            url: '<%=basePath%>role/button.modal?roleId=' + roleId + "&type=" + type
            , width: 500
            , title: "授权权限"
        });
    }


    function editName(roleId, ele, roleName) {
        $(ele).parent('td').html(template("editName", {roleId: roleId, roleName: roleName}));
        $("#roleName" + roleId).focus();
    }

    function saveName(roleId, roleNameRestore) {
        var roleName = $("#roleName" + roleId).val();
        if (!roleName) {
            $.DialogAlert({
                title: '提示',
                content: roleId + '修改失败===' + roleNameRestore
            })
            $("#roleName" + roleId).parent("td").html(template("nameTemp", {
                roleName: roleNameRestore,
                roleId: roleId
            }));
            return;
        }
        $.ajax({
            url: 'role/saveName',
            type: 'post',
            data: {roleId: roleId, roleName: roleName},
            dataType: 'json',
            success: function (result) {
                $.loadViewOrModal();
            }
        })
    }

    function removeRole(roleId) {
        swalConfirm({
            text: "是否删除",
            icon: swalIcon.WARNING,
            OK: function () {
                remove(roleId);
            }
        })
    }

    function remove(roleId) {
        var params = {
            roleId: roleId
        };
        $.ajax({
            url: '<%=basePath%>role/remove.do',
            type: 'post',
            data: params,
            dataType: 'json',
            success: function (result) {
                if (result.status == 'success') {
                    $.loadViewOrModal();
                } else {
                    swal(result.message, "", "success");
                }
            }
        })
    }
</script>
