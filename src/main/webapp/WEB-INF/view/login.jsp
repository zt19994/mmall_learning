<%--
  Created by IntelliJ IDEA.
  User: ZT
  Date: 2018/1/13
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>登录页面</title>
    <script type="text/javascript" src="/static/jquery-2.1.3.min.js"></script>
</head>
<body>
<div>
    <h1 align="center">登录页面</h1>
</div>
<div align="center">
    <table>
        <tr>
            <td>用户名:</td>
            <td>
                <input id="username"  type="text" value="">
            </td>
        </tr>
        <tr>
            <td>密 码:</td>
            <td>
                <input id="password"  type="password" value="">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button onclick="login()">登录</button>
            </td>
        </tr>
    </table>
</div>
</body>
<script>
    function login() {
        var username = $("#username").val();
        var password = $("#password").val();
        var params = {
            username:username,
            password:password
        };
        var url = 'http://localhost:8080/user/login.do';
        jQuery.ajax({
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded',
            url: url,
            data: params,
            dataType: 'json',
            success: function (data) {
                var status = data.status;
                var msg = data.msg;
                alert(status);
                alert(msg);
                alert("成功啦");
            },
            error: function (data) {
                alert("失败啦");
            }
        });
    }
</script>
</html>
