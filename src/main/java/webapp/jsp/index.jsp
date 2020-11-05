<%--
  Created by IntelliJ IDEA.
  User: Daved
  Date: 2020/6/10
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>登录</title>
    <%@include file="head.jsp"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/index.js" type="text/javascript"></script>
    <script>
        function changevalidateCode(){
            window.location.href=<%=basePath%>/validateCode+;
        }
        function submitForm(){
            var userName = $("#userName").val();
            var password = $("#password").val();
            if(userName === ""){
                alert("请输入用户姓名！");
                return false;
            }
            if (password === ""){
                alert("请输入密码！");
                return false;
            }
            $.ajax({
                url:"<%=basePath%>/employee/login",
                contentType:"application/json",
                datatype:"json",
                method:"post",
                data:JSON.stringify({'userName':userName,'password':password}),
                success:function(data){
                    if(data==="success"){
                        alert("登录成功");
                        window.location.href="list"
                    }else{
                        alert("登录失败");
                    }
                },

                
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status+","+textStatus);
                },
            })
        }
    </script>
</head>
<body style="background-image: url(${pageContext.request.contextPath}/imgs/P1010122.JPG);background-repeat: no-repeat;background-size: cover;background-position: center center;">
<form action="/employee/login" method="post">
    <div align="center">
        <div align="center" style="margin: 20px;font-family: 微软雅黑;font-size: xx-large;"> 登录 </div>
        <table align="center" style="margin-top: 20px;font-family:微软雅黑;font-size: large; border: 0;margin-top: 10%;" class="form" >
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：</td>
                <td> <input type="text" id="userName" name="userName"style="border-top: 0; border-left: 0;border-right: 0;border-bottom: 1px solid yellowgreen; background: unset"></td>
            </tr>
            <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码：</td><td><input type="password" id="password" name="password"style="border-top: 0; border-left: 0;border-right: 0;border-bottom: 1px solid yellowgreen;background: unset"></td></tr>
            <tr><td>验证码</td><td><img src="<%=basePath%>/validateCode" alt="验证码" onclick="changevalidateCode()+Math.random()"></td></tr>
            <tr><td></td><td><input type="button" value="登录" onclick="submitForm()"style=" color: yellowgreen;border: 0px ;background: blueviolet; margin-left: 70%;border-radius: 15px; font-size: 30px"></td></tr>
        </table>
    </div>
</form>
</body>
</html>
