<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kwakseobang
  Date: 10/5/24
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${param.result == 'error'}">
    <h1>로그인 에러</h1>
</c:if>

<form action="/login" method="post">
  <input type="text" name="mid">
  <input type="text" name="mpw">
  <button type="submit">Login </button>
</form>

</body>
</html>
