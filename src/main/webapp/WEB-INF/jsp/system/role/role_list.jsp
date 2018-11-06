<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <jsp:include page="${jspPath}/view/head.jsp"></jsp:include>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body" pad15>
                    <table id="role-table" class="layui-table">

                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="${jspPath}/view/foot.jsp"></jsp:include>
<script src="${ctx}static//js/role/role.js"></script>
</body>
</html>