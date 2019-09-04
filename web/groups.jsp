<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <title>Groups</title>
</head>
<body>
<div class="container">
    <br/>
    <div class="row">
        <div class="col-md-12">
            <h2 align="center">Groups</h2>
        </div>
        <div class="col-md-12"></div>
    </div>
    <br/>
    <div class="col-md-12" align="center">
        <form action="${pageContext.request.contextPath}/group" method="get">
            <input required name="id" placeholder="Group id">
            <button type="submit" class="btn btn-primary">Find</button>
            <button type="button" id="createForm" class="btn btn-primary">New Group</button>
        </form>
    </div>
    <br/>
    <table class="table table-bordered table-striped table-hover">
        <thread>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th class="text-center" colspan="2">Action</th>
            </tr>
        </thread>
        <tbody>
        <c:forEach var="group" items="${groups}">
            <tr>
                <td><c:out value="${group.id}"/></td>
                <td class="pointer" title="Show students"><c:out value="${group.name}"/></td>
                <td class="text-center">
                    <button type="button" class="btn-dark edit-group">Edit</button>
                </td>
                <td class="text-center">
                    <form action="${pageContext.request.contextPath}/group/delete" method="post">
                        <input hidden name="groupId" value="${group.id}">
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
                <label>Group</label>
                <input hidden class="form-control" id="groupId" name="groupId">
                <input required type="text" class="form-control" id="name" name="name" style="width:250px;"
                       placeholder="Name">
            </div>
            <button id="create" type="submit" value="groups" class="btn btn-primary">Create</button>
            <button id="update" type="submit" value="group" class="btn btn-danger">Update</button>
        </form>
    </div>
    <a class="btn btn-warning" role="button" onClick="history.go(-1)">Back</a>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    $('.table tbody').on('click', '.btn-dark', function () {
        $("#form").show();
        $("#create").hide();
        $("#update").show();
        var currentRow = $(this).closest('tr');
        document.getElementById("groupId").value = currentRow.find('td:eq(0)').text();
        document.getElementById("name").value = currentRow.find('td:eq(1)').text();
    })
        .on('click', '.pointer', function () {
            var groupId = $(this).closest('tr').find('td:eq(0)').text();
            document.location.href = "${pageContext.request.pathInfo}/group?id=" + groupId;
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
