<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Предмети</title>
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
    <a href="<c:url value="/subject/add"></c:url>"><h3>Додати предмет</h3></a></li>
    <div class="row">
        <table class="table table-striped">

            <tr>
                <td>Предмет</td>
                <td>Перехід</td>
            </tr>
            <c:forEach items="${listSubject}" var="entry">
                <tr>
                    <td>${entry.name}</td>
                    <td><a href="<c:url value='/vals/subject/${entry.id}'/>">Перейти</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</body>
</html>
