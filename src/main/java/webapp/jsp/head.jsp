<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
    pageContext.setAttribute("basePath",basePath);    
%>
<html>
<head>
    <%@include file="bootstrap.jsp" %>
    <%@include file="tag.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/head.css" type="text/css" rel="stylesheet">
    <script>
        function register() {
            window.location.href="<%=basePath%>user/showRegister"
        }
        function loginOut(){
            window.location.href="<%=basePath%>user/loginOut"
            $.ajax({
                url:"<%=basePath%>/user/loginOut",
                type:"get",
                contentType:"application/json",
                datatype:"json",
                success:function(data){
                    if(data="true"){
                        alert("退出成功");
                        window.location.href="<%=basePath%>"
                    }else{
                        alert(data);
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status+","+textStatus);
                },
            });
        }
    </script>
</head>
<body>
    <div class="top">
        <br>
        <div class="title">人员管理系统</div>
        <p class="welcome">欢迎 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:if test="${sessionScope.user==null}">请先 <a href="<%=basePath%>user/index">登录</a>&nbsp;<input type="button"style="background: aliceblue; border: 0px;border-radius: 20px; " value="注册" onclick="register()"></c:if>
            ${sessionScope.user}&nbsp;&nbsp;&nbsp;&nbsp;
            <c:if test="${sessionScope.user!=null}"><input type="button" value="退出" onclick="loginOut()" style="background: aliceblue; border: 0px;border-radius: 20px;"></c:if>

            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
    </div>
</body>
</html>

