<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <script type="text/javascript">

        function getAllUser() {
            $.ajax({
                type: "post",
                url: "get_user.do",
                success: function (result) {
                    layer.msg(result),setTimeout(
                        function () {
                        },2000
                    );
                }
            })
        }
    </script>
</head>
<body onload="getAllUser()">
<h1>欢迎你：<%= session.getAttribute("username")%></h1>
<a href="mySee.jsp">我的关注</a>
<table>
    <tr>
        <td>用户</td>
        <td>密码</td>
        <td>操作<button onclick="getAllUser()"></button></td>
    </tr>
</table>
</body>
</html>