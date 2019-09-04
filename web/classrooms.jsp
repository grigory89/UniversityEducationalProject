<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <title>Classrooms</title>
</head>
<body>
<div class="container">
    <br/>
    <div class="col-md-12">
        <h2 align="center">Classrooms</h2>
    </div>
    <br/>
    <div class="col-md-12" align="center">
        <form action="${pageContext.request.contextPath}/classroom" method="get">
            <div class="form-group">
                <input required name="number" placeholder="Number">
            </div>
            <button type="submit" class="btn btn-warning">Find</button>
            <a class="btn btn-warning" role="button" href="${pageContext.request.contextPath}/classrooms">Show all</a>
        </form>
    </div>
    <br/>
    <table class="table table-bordered table-striped table-hover">
        <thread>
            <tr>
                <th>Room number</th>
                <th>Action</th>
            </tr>
        </thread>
        <tbody>
        <c:forEach var="classroom" items="${classrooms}">
            <tr>
                <td><c:out value="${classroom.roomNumber}"/></td>
                <td class="text-center">
                    <form action="${pageContext.request.contextPath}/classroom" method="post">
                        <input type="hidden" name="number" value="${classroom.roomNumber}">
                        <button class="btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
    <div class="col-md-12" align="center">
        <form action="${pageContext.request.contextPath}/classrooms" method="post">
            <div class="form-group">
                <label>Classroom</label>
                <input required type="number" class="form-control" name="number" style="width:250px;"
                       placeholder="Number">
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
        </form>
    </div>
    <br/>
    <a class="btn btn-warning" role="button" href="${pageContext.request.contextPath}/index">Back to main page</a>
</div>
</body>
</html>
