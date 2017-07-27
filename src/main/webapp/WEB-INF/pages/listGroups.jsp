<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список груп</title>
</head>
<body>
<table>
    <tr>
        <td>Група</td>
        <td>Перейти</td>
    </tr>
    <c:forEach items="${listGroups}" var="entry">
        <tr>
            <td>${entry.name}</td>
            <td><a href="<c:url value='/selectGroup/${entry.id}'/>">Перейти</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
