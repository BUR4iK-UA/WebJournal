<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизація</title>
</head>
<body>
<form action="<c:url value="/login/auth" />">
    Логін:<br>
    <input type="text" name="login" id="login" value="${user.login}">
    <br>
    Пароль:<br>
    <input type="text" name="pass" id="pass" value="${user.pass}">
    <br><br>
    <p><input type="submit"></p>
</form>

</body>
</html>
