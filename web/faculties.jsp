<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <title>Faculties</title>
</head>
<body>
<div class="container">
    <br/>
    <div class="col-md-12">
        <h2 align="center">Faculties</h2>
    </div>
    <br/>
    <div class="col-md-12" align="center">
        <form action="${pageContext.request.contextPath}/faculty" method="get">
            <input required name="id" placeholder="Faculty id">
            <button type="submit" class="btn btn-primary">Find</button>
            <button type="button" id="createForm" class="btn btn-primary">New Faculty</button>
        </form>
    </div>
    <br/>
    <table id="table" class="table table-bordered table-striped table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="faculty" items="${faculties}">
            <tr>
                <td><c:out value="${faculty.id}"/></td>
                <td class="pointer"><c:out value="${faculty.name}"/></td>
                <td class="text-center">
                    <button type="button" class="btn-dark edit-group">Edit</button>
                </td>
                <td class="text-center">
                    <form action="${pageContext.request.contextPath}/faculty/delete" method="post">
                        <input hidden name="facultyId" value="${faculty.id}">
                        <button type="submit" class="btn-danger">Delete</button>
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
                <label>Faculty</label>
                <input hidden id="id" class="form-control" name="facultyId">
                <input required type="text" id="name" class="form-control" name="name" style="width:250px;"
                       placeholder="Name">
            </div>
            <button id="create" type="submit" value="faculties" class="btn btn-primary">Create</button>
            <button id="update" type="submit" value="faculty" class="btn btn-danger">Update</button>
        </form>
    </div>
    <br/>
    <a class="btn btn-warning" role="button" href="${pageContext.request.contextPath}/index">Back to main page</a>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    $('.table tbody').on('click', '.btn-dark', function () {
        $("#form").show();
        $("#create").hide();
        $("#update").show();
        var currentRow = $(this).closest('tr');
        document.getElementById("id").value = currentRow.find('td:eq(0)').text();
        document.getElementById("name").value = currentRow.find('td:eq(1)').text();
    })
        .on('click', '.pointer', function () {
            var currentId = $(this).closest('tr').find('td:eq(0)').text();
            document.location.href = "${pageContext.request.contextPath}/faculty?id=" + currentId;
        });
    $(document).ready(function () {
        $(document).ready(function () {
            $("#createForm").click(function () {
                $("#form").show();
                $("#create").show();
                $("#update").hide();
            });
        });
    });

    function modifyAction() {
        this.form.action = "${pageContext.request.contextPath}/" + this.value;
    }

    $("#update, #create").click(modifyAction);
</script>
</body>
</html>
