<%--
  Created by IntelliJ IDEA.
  User: qitiandasheng
  Date: 2019/6/25
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <script src="jquery-2.1.4/jquery-1.8.0.min.js"></script>
    <script src="jquery-2.1.4/layer/layer.js"></script>
    <title>登录</title>
</head>
<body>
<form id="loginform" action="insert.do" method="post" >
<%--    collection：<input  value="collection" name="collection"><br>--%>
    id：<input type="number" value="0" name="id"><br>
    日期：<input   name="datetime"><br>
    图片：<input  name="thumbnail"><br>
    来源：<input  name="source"><br>
    内容：<input   name="summary"><br>
<%--    thumbnail：<input  value="thumbnail" name="thumbnail"><br>--%>
    标题：<input   name="title"><br>
<%--    whetherAdvertising：<input  value="whetherAdvertising" name="whetherAdvertising"><br>--%>
<%--    whetherCollection：<input  value="whetherCollection" name="whetherCollection"><br>--%>
<%--    whetherPay：<input  value="whetherPay" name="whetherPay"><br>--%>
<%--    type：<input value="type" name="type"><br>--%>
<%--    datetime：<input type="date" name="datetime"><br>--%>
    <input type="submit" value="提交" >
</form>
</body>
</html>
