<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Оцінки</title>
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
        <input type="number" id="value" min="1" max="5">
        <button id="submit">Поставити оцінку</button>
    </div>
    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <c:forEach begin="0" end="20">
                    <th><a href="<c:url value='/addValsInNewDay/${idSubject}'/> ">+</a></th>
                </c:forEach>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${map}" var="entry">
                <tr>
                    <td>${entry.key.lastName}</td>
                    <td>${entry.key.firstName}</td>
                    <c:forEach items="${entry.value}" var="vals" begin="0" end="20">
                    <td id="${vals.id}">
                        <c:choose>
                        <c:when test="${vals.value<0}">

                        </c:when>
                        <c:otherwise>

                        </c:otherwise>
                        </c:choose>

                        </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script>
    $(document).ready(function () {
        $('td').click(function () {
            var val = $(this).attr('id');
            $(this).attr('bgcolor', 'red');
            $('#submit').click(function () {
                var value = $("#value").val();
                $.ajax({
                    url: '/updateval/' + val,
                    metod: "GET",
                    data: {valuation: value},
                });
                location.reload(true);
            });
        });
    });
</script>


</body>
</html>

