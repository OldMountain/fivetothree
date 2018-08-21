<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Login</title>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="static/css/login.css" rel='stylesheet' type='text/css'/>
    <link rel="Shortcut Icon" href="static/images/icon.ico" type="image/x-icon"/>
    <script type="text/javascript" src="static/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="static/js/sweetalert.min.js"></script>
    <style>
        body #SOHUCS {
            width: 25%;
            position: absolute;
            top: 10%;
            right: 3%;
        }
    </style>
</head>
<body>
<!--SIGN UP-->
<h1>523</h1>
<div class="login-form">
    <div class="avtar">
        <img src="static/images/avtar.png"/>
    </div>
    <form>
        <input type="text" class="text" name="userName" id="userName" placeholder="Username" onfocus="this.value = '';">
        <input type="password" name="password" id="password" placeholder="Password" onfocus="this.value = '';">
        <input type="text" class="text" name="code" id="code" placeholder="Code" onfocus="this.value = '';">
        <img id="codeImg" src="" width="80px">
    </form>
    <div class="signin">
        <input type="submit" value="Login" onclick="login()">
    </div>
    <!--PC版-->
</div>
<div id="SOHUCS" sid="ftt20170227"></div>
<jsp:include page="../../changyan/comment.jsp"></jsp:include>
</body>
<script>

    $(function () {
        $("#codeImg").attr("src", "code.do?t=" + new Date().getTime());
        $("#codeImg").click(function () {
            $("#codeImg").attr("src", "code.do?t=" + new Date().getTime());
        })
    })

    function login() {
        var login = $(".signin input").val();
        var userName = $("#userName").val();
        var password = $("#password").val();
        var code = $("#code").val();
        if (!userName) {
            swal("用户名不能为空", "", "warning");
            return;
        }
        if (!password) {
            swal("密码不能为空", "", "warning");
            return;
        }
        if (!code) {
            swal("验证码不能为空", "", "warning");
            return;
        }
        var params = {
            userName: userName,
            password: password,
            code: code,
        };
        $.ajax({
            url: '<%=basePath%>login',
            type: 'post',
            data: params,
            dataType: 'json',
            beforeSend: function () {
                $(".signin input").val("正在登录...");
            },
            success: function (result) {
                if (result.status == 'success') {
                    $(".signin input").val("登录成功");
                    window.location.href = "<%=basePath%>toIndex";
                } else {
                    $(".signin input").val(login);
                    swal(result.message, "", "error");
                }
            }
        })
    }
</script>
</html>
