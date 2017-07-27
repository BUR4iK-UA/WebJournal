<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Додавання групи</title>
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
        <h1>Додавання групи</h1>
        <div class="form-signin">
            <form:form method="post" commandName="group">
                <table>
                    <tr>
                        <td>Назва групи:</td>
                        <td><form:input cssClass="form-control" path="name"/></td>
                    </tr>
                    <tr>
                        <td>Ід куратора:</td>
                        <td><form:input cssClass="form-control" path="idCurator"/></td>
                    </tr>

                    <tr>
                        <td>Дата створення:</td>
                        <td><form:input cssClass="form-control" path="dateCreate"/></td>
                    </tr>

                    <tr>
                        <td colspan="2"><input type="submit" value="Submit" class="btn btn-sn btn-success"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped">
            <tr>
                <td>Група</td>
                <td>Число студентів</td>
                <td>Дата створення</td>
                <td>Перехід</td>
            </tr>
            <c:forEach items="${listGroup}" var="entry">
                <tr>
                    <td>${entry.name}</td>
                    <td>${entry.studentsCount}</td>
                    <td>${entry.dateCreate}</td>
                    <td><a href="<c:url value='/selectGroup/${entry.id}'/>">Перейти</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>


</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</html>

