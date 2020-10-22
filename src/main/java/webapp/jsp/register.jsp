<%--
  Created by IntelliJ IDEA.
  User: Daved
  Date: 2020/6/14
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <%@include file="head.jsp" %>
    <script>
        function register1() {
            var username =$("#username").val();
            var userpassword=$("#password").val();
            if (username === ""){
                alert("请输入用户名");
                return false;
            }
            if (userpassword === ""){
                alert("请输入密码");
                return false;
            }
            $.ajax({
                url:"<%=basePath%>user/register",
                type:"post",
                contentType:"application/json",
                datatype:"json",
                data:JSON.stringify({'username':username,'userpassword':userpassword}),
                success:function(data){
                    if(data==="success"){
                        alert("注册成功");
                        window.location.href="<%=basePath%>/user/index"
                    }else{
                        alert(data);
                    }
                },
            })
        }
    </script>
    <link rel="stylesheet" href="../css/register.css" type="text/css">
</head>
<body style="background-image: url(${pageContext.request.contextPath}/imgs/P1010122.JPG);background-repeat: no-repeat;background-size: cover;background-position: center center;">
<div align="center" style="margin: 20px;font-family: 微软雅黑;font-size: xx-large;"> 请准确填写管理员信息 </div>
<form action="/user/register" method="post">
    <table align="center" style="margin-top: 20px;font-family:微软雅黑;font-size: large; border: 0;" class="form" >
        <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名:</td><td><input type="text" id="username" name="username" style="border-top: 0; border-left: 0;border-right: 0;border-bottom: 1px solid yellowgreen; background: unset"></td></tr>
        <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码:</td><td><input type="password" id="password" name="password" style="border-top: 0; border-left: 0;border-right: 0;border-bottom: 1px solid yellowgreen; background: unset"></td></tr>
        <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;授权码:</td><td><input type="text" id="authorize" name="authorize" style="border-top: 0; border-left: 0;border-right: 0;border-bottom: 1px solid yellowgreen; background: unset"></td></tr>
        <tr><td></td><td><input type="button" value="注册" onclick="register1()" style=" color: yellowgreen;border: 0px ;background: blueviolet; margin-left: 70%;border-radius: 15px; font-size: 30px"></td></tr>
    </table>
</form>
</body>
</html>
