<%--
  Created by IntelliJ IDEA.
  User: qitiandasheng
  Date: 2019/6/25
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <script src="jquery-2.1.4/jquery-1.8.0.min.js"></script>
    <script src="jquery-2.1.4/layer/layer.js"></script>
    <title>登录</title>
    <script type="text/javascript">
        function login() {
            var username = $("#username").val();
            //alert(username);
            //layer.msg(username,3000);
            $.ajax({
                type: "post",
                url: "login.do",
                data: $("#loginform").serialize(),
                success: function (result) {
                    layer.msg(result),setTimeout(
                        function () {
                            if (result == "登录成功"){
                                window.location = "mainpage.jsp"
                            } else {
                                $("#password").val("");
                            }
                        },1000
                    );
                }
            })
        }

    </script>
</head>
<body>
<form id="loginform" align="center" >
    账号：<input id="username" value="admin" name="username"><br>
    密码：<input id="password" value="123" name="password"><br>
    <input type="button" onclick="login()" value="登录" >
</form>
</body>
</html>
