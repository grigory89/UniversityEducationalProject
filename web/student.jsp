<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<div class="container">
    <br/>
    <div class="col-md-12">
        <h2 align="center"> Student ${student.name} </h2>
    </div>
    <br/>
    <div class="col-md-12" align="center">
        <div class="col-md-12" align="center">
            <form action="${pageContext.request.contextPath}/student" method="post">
                <div class="form-group">
                    <input hidden type="number" id="studentId" class="form-control name" name="studentId"
                           style="width:250px;"
                           placeholder="Id">
                    <input required type="text" id="name" class="form-control name" name="name" style="width:250px;"
                           placeholder="Name">
                    <input required type="text" id="phone" class="form-control" name="phoneNumber" style="width:250px;"
                           placeholder="Phone number">
                    <input required type="number" id="idCard" class="form-control" name="idCard" style="width:250px;"
                           placeholder="Id card">
                    <select class="form-control js-example-tags" name="groupId" style="width:250px;">
                        <option disabled selected>Select group</option>
                        <c:forEach items="${groups}" var="group">
                            <option value="${group.id}">${group.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Update</button>
            </form>
            <form action="${pageContext.request.contextPath}/student/delete" method="post">
                <input type="hidden" name="id" value="${student.id}">
                <button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure?');">Delete</button>
            </form>
        </div>
    </div>
    <a class="btn btn-warning" role="button" onClick="history.go(-1)">Back</a>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        document.getElementById("studentId").value = "${student.id}";
        document.getElementById("name").value = "${student.name}";
        document.getElementById("phone").value = "${student.phoneNumber}";
        document.getElementById("idCard").value = "${student.idCard}";
    });
</script>
</body>
</html>
