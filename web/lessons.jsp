<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <title>Schedule</title>
</head>
<body>
<div class="container">
    <br/>
    <div class="col-md-12">
        <h2 align="center">Lessons</h2>
    </div>
    <br/>
    <div class="col-md-12" align="center">
        <form action="${pageContext.request.contextPath}/lesson" method="get">
            <div class="form-group">
                <select required class="form-control js-example-tags" name="teacherId" style="width:200px;">
                    <option disabled selected>Search by teacher</option>
                    <c:forEach items="${teachers}" var="teacher">
                        <option value="${teacher.id}">${teacher.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button class="btn btn-warning">Find</button>
            <a class="btn btn-warning" role="button" href="${pageContext.request.contextPath}/lessons">Show all</a>
        </form>
        <button type="button" id="createForm" class="btn btn-primary">Create lesson</button>
    </div>
    <br/>
    <table id="table1" class="table table-bordered table-striped table-hover">
        <thread>
            <tr>
                <th>Id</th>
                <th>Time</th>
                <th>Teacher</th>
                <th>Subject</th>
                <th>Classroom</th>
                <th>Groups</th>
                <th colspan="2">Action</th>
            </tr>
        </thread>
        <tbody>
        <c:forEach var="lesson" items="${lessons}">
            <tr>
                <td><c:out value="${lesson.id}"/></td>
                <td><c:out value="${lesson.dateTime}"/></td>
                <td data-val="${lesson.teacher.id}"><c:out value="${lesson.teacher.name}"/></td>
                <td data-val="${lesson.subject.id}"><c:out value="${lesson.subject.name}"/></td>
                <td><c:out value="${lesson.classroom.roomNumber}"/></td>
                <c:forEach var="group" items="${lesson.groups}">
                    <td hidden data-value="${group.id}"></td>
                </c:forEach>
                <td>
                    <select name="forma" onchange="window.location.href = this.value;">
                        <option>Groups</option>
                        <c:forEach var="group" items="${lesson.groups}">
                            <option value="${pageContext.request.contextPath}/group?id=${group.id}">${group.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td class="text-center">
                    <button type="button" class="btn-dark">Edit</button>
                </td>
                <td class="text-center">
                    <form action="${pageContext.request.contextPath}/lesson/delete" method="post">
                        <input hidden name="lessonId" value="${lesson.id}">
                        <button type="submit" class="btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
    <div class="col-md-12" align="center">
        <form style="display: none" id="form" action="" method="post">
            <div class="form-group">
                <label>Lesson</label>
                <input hidden id="lessonId" class="form-control" name="lessonId">
                <input required id="date" type="datetime-local" class="form-control"
                       name="date" placeholder="Date" style="width:250px;">
                <select required id="teacher" class="form-control js-example-tags" name="teacher" style="width:250px;">
                    <option disabled selected>Select teacher</option>
                    <c:forEach items="${teachers}" var="teacher">
                        <option data-sub="${teacher.subject.id}" value="${teacher.id}">${teacher.name}</option>
                    </c:forEach>
                </select>
                <br/>
                <select required id="classroom" class="form-control js-example-tags" name="classroom"
                        style="width:250px;">
                    <option disabled selected>Select classroom</option>
                    <c:forEach items="${classrooms}" var="classroom">
                        <option value="${classroom.roomNumber}">${classroom.roomNumber}</option>
                    </c:forEach>
                </select>
                <br/>
                <select required id="subject" class="form-control js-example-tags" name="subject" style="width:250px;">
                    <option disabled selected>Select subject</option>
                    <c:forEach items="${subjects}" var="subject">
                        <option value="${subject.id}">${subject.name}</option>
                    </c:forEach>
                </select>
                <br/>
                <select required id="groups" class="form-control js-example-placeholder-multiple js-states"
                        name="groups" multiple="multiple" style="width:250px;">
                    <c:forEach items="${groups}" var="group">
                        <option value="${group.id}">${group.name}</option>
                    </c:forEach>
                </select>
                <br/>
            </div>
            <button type="submit" id="update" value="lesson" class="btn btn-danger">Update</button>
            <button type="submit" id="create" value="lessons" class="btn btn-primary">Create</button>
        </form>
    </div>
    <br/>
    <a class="btn btn-warning" role="button" href="${pageContext.request.contextPath}/index">Back to main page</a>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
<script>
    var data = [];
    $('.table tbody').on('click', '.btn-dark', function () {
        $("#form").show();
        $("#update").show();
        $('#create').hide();
        var currentRow = $(this).closest('tr');
        document.getElementById("lessonId").value = currentRow.find('td:eq(0)').text();
        document.getElementById("date").value = currentRow.find('td:eq(1)').text();
        var teacherId = currentRow.find('td:eq(2)').data('val');
        var subjectId = currentRow.find('td:eq(3)').data('val');
        var room = currentRow.find('td:eq(4)').text();
        $('#teacher').val(teacherId).trigger('change');
        $('#subject').val(subjectId).trigger('change');
        $('#classroom').val(room).trigger('change');
        var currentIndex = currentRow[0].rowIndex;
        var length = document.getElementById('table1').rows[currentIndex].cells.length;
        var groups = [];
        for (var i = 5; i < (length - 2); i++) {
            groups.push(currentRow.find('td').eq(i).data('value'));
        }
        $('#groups').val(groups).trigger('change');
    });

    $(document).ready(function () {
        $("#createForm").click(function () {
            $("#form").show();
            $("#create").show();
            $('#update').hide();
        })
    });
    $(".js-example-tags").select2({
        tags: true
    });
    $(".js-example-placeholder-multiple").select2({
        placeholder: "Add groups to lesson"
    });

    function select() {
        var subjectId = document.getElementById("teacher").value[0];
        $('#subject').val(subjectId).trigger('change');
    }

    $("#teacher").change(function () {
        var subjectId = $(this).find(':selected').data('sub');
        $('#subject').val(subjectId).trigger('change');
    });

    function modifyAction() {
        this.form.action = "${pageContext.request.contextPath}/" + this.value;
    }

    $("#update, #create").click(modifyAction);
</script>
</body>
</html>
