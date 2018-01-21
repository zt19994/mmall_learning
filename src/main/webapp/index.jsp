<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>导航页面</title>
    <script type="text/javascript" src="/static/jquery-2.1.3.min.js"></script>
</head>
<body>
<div>
    <h1 align="center">导航页面</h1>
</div>
<div align="center">
    <button onclick="toLogin()">登录页面</button>
    <button onclick="toRegister()">注册页面</button>
</div>
<div align="center">
    springmvc上传文件
    <form name="form1" action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
        <input type="file" name="upload_file" />
        <input type="submit" value="springmvc上传文件" />
    </form>

    富文本图片上传文件
    <form name="form2" action="/manage/product/richtext_img_upload.do" method="post" enctype="multipart/form-data">
        <input type="file" name="upload_file" />
        <input type="submit" value="富文本图片上传文件" />
    </form>
</div>
</body>
<script type="text/javascript">
    function toLogin() {
        window.location.href="http://localhost:8080/user/toLogin.do";
    }

    function toRegister() {
        window.location.href="http://localhost:8080/user/toRegister.do";
    }
</script>
</html>
