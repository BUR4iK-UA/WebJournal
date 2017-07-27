<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Список</title>
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container theme-showcase" role="main">
    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/"></c:url> ">Home</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="<c:url value="/group/add"></c:url> ">Групи<span class="sr-only">(current)</span></a>
                    </li>
                    <li><a href="<c:url value="/students"></c:url>">Студенти</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    <div class="container">
        <h1>Додавання студента</h1>
        <div class="form-signin">
            <form:form method="post" commandName="student">
                <table>
                    <tr>
                        <td>Прізвище:</td>
                        <td><form:input cssClass="form-control" path="lastName"/></td>
                    <tr>
                        <td>І'мя:</td>
                        <td><form:input cssClass="form-control" path="firstName"/></td>
                    </tr>
                    <tr>
                        <td>Група:</td>
                        <td>
                            <form:select cssClass="form-control" path="idGroup">
                                <form:options items="${listGroups}" itemLabel="name" itemValue="id"/>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3"><input type="submit" value="Додати" class="btn btn-sn btn-success"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
    <div class="row">
        <table class="table table-srtiped">
            <tr>
                <td>Прізвище</td>
                <td>І'мя</td>
                <td>Індетифікатор групи</td>
                <td></td>
            </tr>
            <c:forEach items="${listStudents}" var="entry">
                <tr>
                    <td>${entry.lastName}</td>
                    <td>${entry.firstName}</td>
                    <td>${entry.idGroup}</td>
                    <td><a href="<c:url value='/students/remove/${entry.id}'/>">Видалити</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</body>
</body>
</html>
