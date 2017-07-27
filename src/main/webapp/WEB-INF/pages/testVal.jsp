<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Тест Оцінок</title>
</head>
<body>
<h1>Тест оцінок</h1>

<form:form method="post" commandName="valuation">
    <table>
        <tr>
            <td>Присутність:</td>
            <td><form:checkbox path="presense"/></td>
        </tr>
        <tr>
            <td>Ід студента:</td>
            <td><form:input path="idStudent"/></td>
        </tr>

        <tr>
            <td>Оцінка:</td>
            <td><form:input path="value"/></td>
        </tr>

        <tr>
            <td>Предмет:</td>
            <td><form:input path="idSubject"/></td>
        </tr>

        <tr>
            <td colspan="4"><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
