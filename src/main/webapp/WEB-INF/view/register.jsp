<%--
  Created by IntelliJ IDEA.
  User: ZT
  Date: 2018/1/13
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>注册页面</title>
    <script type="text/javascript" src="/static/jquery-2.1.3.min.js"></script>
</head>
<body>
<div>
    <h1 align="center">注册页面</h1>
</div>
<div align="center">
    <table>
        <tr>
            <td>用户名:</td>
            <td>
                <input id="username" type="text" value="">
            </td>
        </tr>
        <tr>
            <td>密 码:</td>
            <td>
                <input id="password" type="password" value="">
            </td>
        </tr>
        <tr>
            <td>邮 箱:</td>
            <td>
                <input id="email" type="text" value="">
            </td>
        </tr>
        <tr>
            <td>手机号码:</td>
            <td>
                <input id="phone" type="text" value="">
            </td>
        </tr>
        <tr>
            <td>提示问题:</td>
            <td>
                <input id="question" type="text" value="">
            </td>
        </tr>
        <tr>
            <td>问题答案:</td>
            <td>
                <input id="answer" type="text" value="">
            </td>
        </tr>
        <tr >
            <td colspan="2" align="center">
                <button onclick="register()">注册</button>
            </td>
        </tr>
    </table>
</div>
</body>
<script type="text/javascript">
    function register() {
        var username = $("#username").val();
        var password = $("#password").val();
        var email = $("#email").val();
        var phone = $("#phone").val();
        var question = $("#question").val();
        var answer = $("#answer").val();
        var params = {
            username:username,
            password:password,
            email:email,
            phone:phone,
            question:question,
            answer:answer
        };
        var url = 'http://localhost:8080/user/register.do';
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
