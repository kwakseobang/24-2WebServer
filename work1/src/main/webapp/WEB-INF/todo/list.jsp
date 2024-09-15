<%--
  Created by IntelliJ IDEA.
  User: kwakseobang
  Date: 9/15/24
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List Page </h1>
    <ul>
        <!--items는 배열이나 리스트를 의미하고 var는 반복문 내에서만 사용하는 변수 이름 -->
        <c:forEach var="dto" items="${list}">
            <li>${dto}</li>
        </c:forEach>
    </ul>
</body>
</html>
