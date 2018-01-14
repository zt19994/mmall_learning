<%--
  Created by IntelliJ IDEA.
  User: ZT
  Date: 2018/1/14
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>忘记密码</title>
    <script type="text/javascript" src="/static/jquery-2.1.3.min.js"></script>
</head>
<body>
<div>
    <h1 align="center">找回密码</h1>
</div>
<div align="center">
    用户名:<input id="username" type="text" placeholder="请输入用户名" value="">
    <br/>
    <br/>
    <button onclick="checkName()">下一步</button>
</div>
</body>
<script type="text/javascript">
    function checkName() {
        alert("检查用户名是否正确");
    }
</script>
</html>
