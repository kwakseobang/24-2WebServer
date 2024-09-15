<%--
  Created by IntelliJ IDEA.
  User: kwakseobang
  Date: 9/15/24
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form> <!--입력 양식 태그 사용자가 입력하는 내용들을 전송하는 용도 -->
        <input type="number" name="num1"> <!-- 문자나 숫자 등을 입력하는 용도 -->
        <input type="number" name="num2">
        <button type="submit"> 전송 </button> <!-- 화면에 버튼을 보여주고 <form> 태그의 전송을 목적으로 하는 경우에는 type="submit" -->
    </form>

    <form action="calcResult.jsp" method="post"> <!-- form 태그의 action을 저 파일로 전송하고, 전송방식은 post -->
        <input type="number" name="num1"> <!-- 문자나 숫자 등을 입력하는 용도 -->
        <input type="number" name="num2">
        <button type="submit"> 전송 </button> <!-- 화면에 버튼을 보여주고 <form> 태그의 전송을 목적으로 하는 경우에는 type="submit" -->
    </form>
</body>
</html>
