<%--
  Created by IntelliJ IDEA.
  User: kwakseobang
  Date: 9/15/24
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1> NUM1 ${param.num1}</h1> <!--JSP에서 사용하는 EL이라는 기술. 서버에서 데이터를 출력하는 용도로 웹에서 sout과 유사한 역할 -->
    <h1> NUM2 ${param.num2}</h1>
    <h1> SUM ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)}</h1>
</body>
</html>
