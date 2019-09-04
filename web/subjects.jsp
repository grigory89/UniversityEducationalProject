<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Subjects</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<div class="container">
    <br/>
    <div class="col-md-12">
        <h2 align="center">Subjects</h2>
    </div>
    <br/>
    <div class="col-md-12" align="center">
        <form action="${pageContext.request.contextPath}/subject" method="get">
            <input required name="id" placeholder="Subject id">
            <button type="submit" class="btn btn-primary">Find</button>
            <button type="button" id="createForm" class="btn btn-primary">New Subject</button>
        </form>
    </div>
    <br/>
    <table class="table table-bordered table-striped table-hover">
        <thread>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th colspan="2">Action</th>
            </tr>
        </thread>
        <tbody>
        <c:forEach var="subject" items="${subjects}">
            <tr>
                <td><c:out value="${subject.id}"/></td>
                <td><c:out value="${subject.name}"/></td>
                <td class="text-center">
                    <button type="button" class="btn-dark">Edit</button>
                </td>
                <td class="text-center">
                    <form action="${pageContext.request.contextPath}/subject/delete" method="post">
                        <input hidden name="subjectId" value="${subject.id}">
                        <button name="action" value="deleteSubject" class="btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
    <div class="col-md-12" align="center">
        <form id="form" style="display: none" action="" method="post">
            <div class="form-group">
                <label>Subject</label>
                <input id="subjectId" class="form-control" name="subjectId" style="width:250px;">
                <input required id="name" type="text" class="form-control input-name" name="name" style="width:250px;"
                       placeholder="Name">
            </div>
            <button id="create" type="submit" value="subjects" class="btn btn-primary">Create</button>
            <button id="update" type="submit" value="subject" class="btn btn-danger">Update</button>
        </form>
    </div>
    <br/>
    <a onClick="history.go(-1)" class="btn btn-warning" role="button">Back</a>
    <a class="btn btn-warning" role="button" href="${pageContext.request.contextPath}/index">Back to main page</a>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    $('.table tbody').on('click', '.btn-dark', function () {
        $("#form").show();
        $("#create").hide();
        $("#update").show();
        var currentRow = $(this).closest('tr');
        document.getElementById("subjectId").value = currentRow.find('td:eq(0)').text();
        document.getElementById("name").value = currentRow.find('td:eq(1)').text();
    });
    $(document).ready(function () {
        $("#createForm").click(function () {
            $("#form").show();
            $("#create").show();
            $("#update").hide();
        });
    });

    function modifyAction() {
        this.form.action = "${pageContext.request.contextPath}/" + this.value;
    }

    $("#update, #create").click(modifyAction);
</script>
</body>
</html>
