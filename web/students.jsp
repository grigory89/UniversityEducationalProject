<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Students</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<div class="container">
    <br/>
    <div class="col-md-12">
        <h2 align="center">Students</h2>
    </div>
    <br/>
    <div class="col-md-12" align="center">
        <form action="${pageContext.request.contextPath}/student" method="get">
            <input required name="id" placeholder="Student id">
            <button type="submit" class="btn btn-primary">Find</button>
            <button type="button" id="createForm" class="btn btn-primary">New Student</button>
        </form>
    </div>
    <div class="col-md-12" align="center">
        <table class="table table-bordered table-striped table-hover">
            <thread>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>IdCard</th>
                    <th colspan="2">Action</th>
                </tr>
            </thread>
            <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td><c:out value="${student.id}"/></td>
                    <td><c:out value="${student.name}"/></td>
                    <td><c:out value="${student.phoneNumber}"/></td>
                    <td><c:out value="${student.idCard}"/></td>
                    <td class="text-center">
                        <button id="btn-link" type="button" class="btn-dark"
                        onclick="goTo(${student.id})">Update</button>
                    </td>
                    <td>
                    <form action="${pageContext.request.contextPath}/student/delete" method="post">
                        <input type="hidden" name="id" value="${student.id}">
                        <button onclick="return confirm('Are you sure?');"
                                type="submit" class="btn-danger" >Delete</button>
                    </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br/>
        <div class="col-md-12" align="center">
            <form id="form" style="display: none" action="${pageContext.request.contextPath}/students" method="post">
                <div class="form-group">
                    <label>Student</label>
                    <input required type="text" id="name" class="form-control name" name="name" style="width:250px;"
                           placeholder="Name">
                    <input required type="text" id="phone" class="form-control" name="phoneNumber" style="width:250px;"
                           placeholder="Phone number">
                    <input required type="text" id="idCard" class="form-control" name="idCard" style="width:250px;"
                           placeholder="Id card">
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>
        </div>
        <br/>
        <a onClick="history.go(-1)" class="btn btn-warning" role="button">Back</a>
        <a class="btn btn-warning" role="button" href="${pageContext.request.contextPath}/index">Back to main page</a>
    </div>
</div>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#createForm").click(function () {
                $("#form").show();
            });
        });
        function goTo(studentId){
            document.location.href="${pageContext.request.contextPath}/student?id=" + studentId;
        }
    </script>
</body>
</html>
