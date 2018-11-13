<%--
  index
  User: luhangqi
  Date: 2018/11/11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layuiAdmin pro - 通用后台管理模板系统（单页面专业版）</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${ctx}static/layadmin/layui/css/layui.css?t=20180921-1" media="all">
    <script>
        var ctx = '${ctx}';
    </script>
</head>
<body>
<div>
    <div id="menu-tree" style="text-align: center;display: none">
        <ul id="indexTreeBox" class="ztree" style="margin: 20px auto;width: 200px"></ul>
    </div>
</div>
<div id="LAY_app"></div>
<script src="${ctx}static/js/jquery-3.2.1.min.js"></script>
<script src="${ctx}static/layadmin/layui/layui.js?t=20180921-1"></script>
<script>
    layui.config({
        base: '${ctx}static/layadmin/dist/' //指定 layuiAdmin 项目路径
    }).use('index', function(){

    });
</script>
</body>
</html>
