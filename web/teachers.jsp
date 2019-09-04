<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Teachers</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<div class="container">
    <br/>
    <div class="col-md-12">
        <h2 align="center">Teachers</h2>
    </div>
    <br/>
    <div class="col-md-12" align="center">
        <form action="${pageContext.request.contextPath}/teacher" method="get">
            <input required name="id" placeholder="Teacher id">
            <button type="submit" class="btn btn-primary">Find</button>
            <button type="button" id="createForm" class="btn btn-primary">New Teacher</button>
        </form>
    </div>
    <br/>
    <table class="table table-bordered table-striped table-hover">
        <thread>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Subject</th>
                <th colspan="2">Action</th>
            </tr>
        </thread>
        <tbody>
        <c:forEach var="teacher" items="${teachers}">
            <tr>
                <td><c:out value="${teacher.id}"/></td>
                <td><c:out value="${teacher.name}"/></td>
                <td data-val="${teacher.subject.id}"><c:out value="${teacher.subject.name}"/></td>
                <td class="text-center">
                    <button type="button" class="btn-dark">Edit</button>
                </td>
                <td class="text-center">
                    <form action="${pageContext.request.contextPath}/teacher/delete" method="post">
                        <input hidden name="teacherId" value="${teacher.id}">
                        <button class="btn-danger">Delete</button>
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
                <label>Teacher</label>
                <input id="teacherId" class="form-control" name="teacherId" style="width:250px;">
                <input required id="name" type="text" class="form-control" name="name" style="width:250px;"
                       placeholder="Name">
                <select id="subject" class="form-control js-example-tags" name="subjectId" style="width:250px;">
                    <option disabled selected>Select subject</option>
                    <c:forEach items="${subjects}" var="subject">
                        <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
                <br/>
            </div>
            <button id="create" type="submit" value="teachers" class="btn btn-primary">Create</button>
            <button id="update" type="submit" value="teacher" class="btn btn-danger">Update</button>
        </form>
    </div>
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
        document.getElementById("teacherId").value = currentRow.find('td:eq(0)').text();
        document.getElementById("name").value = currentRow.find('td:eq(1)').text();
        $('#subject').val(currentRow.find('td:eq(2)').data('val')).trigger('change');
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
