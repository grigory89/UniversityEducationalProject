<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <title>Faculty</title>
</head>
<body>
<div class="container">
    <br/>
    <div class="col-md-12">
        <h2 align="center">${faculty.name} Faculty</h2>
    </div>
    <br/>
    <div class="row">
        <table class="table table-bordered table-striped table-hover">
            <caption style="caption-side: top">Groups
                <a methods="get" class="btn btn-warning" role="button"
                   href="${pageContext.request.contextPath}/groups">Show all</a>
            </caption>
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="group" items="${faculty.groups}">
                <tr>
                    <td><c:out value="${group.id}"/></td>
                    <td class="pointer group"><c:out value="${group.name}"/></td>
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
        <table class="table table-bordered table-striped table-hover">
            <caption style="caption-side: top">Teachers
                <a methods="get" class="btn btn-warning" role="button"
                   href="${pageContext.request.contextPath}/teachers">Show all</a>
            </caption>
            <thread>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Subject</th>
                    <th>Action</th>
                </tr>
            </thread>
            <tbody>
            <c:forEach var="teacher" items="${faculty.teachers}">
                <tr>
                    <td><c:out value="${teacher.id}"/></td>
                    <td class="pointer teacher"><c:out value="${teacher.name}"/></td>
                    <td data-val="${teacher.subject.id}" class="pointer t-subject">
                        <c:out value="${teacher.subject.name}"/></td>
                    <td class="text-center">
                        <form action="${pageContext.request.contextPath}/teacher/delete" method="post">
                            <input type="hidden" name="teacherId" value="${teacher.id}">
                            <button type="submit" class="btn-danger">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br/>
        <table class="table table-bordered table-striped table-hover">
            <caption style="caption-side: top">Subjects
                <a methods="get" class="btn btn-warning" role="button"
                   href="${pageContext.request.contextPath}/subjects">Show all</a>
            </caption>
            <thread>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th class="text-center" colspan="2">Action</th>
                </tr>
            </thread>
            <tbody>
            <c:forEach var="subject" items="${faculty.subjects}">
                <tr>
                    <td><c:out value="${subject.id}"/></td>
                    <td class="pointer subject"><c:out value="${subject.name}"/></td>
                    <td class="text-center">
                        <form action="${pageContext.request.contextPath}/subject/delete" method="post">
                            <input type="hidden" name="id" value="${subject.id}">
                            <button type="submit" class="btn-danger">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <br/>
    <a class="btn btn-warning" role="button" href="${pageContext.request.contextPath}/faculties">Back to faculties</a>
</div>
<br/>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
    $('.table tbody').on('click', '.group', function () {
        var groupId = $(this).closest('tr').find('td:eq(0)').text();
        document.location.href = "${pageContext.request.pathInfo}/group?id=" + groupId;
    })
        .on('click', '.teacher', function () {
            var groupId = $(this).closest('tr').find('td:eq(0)').text();
            document.location.href = "${pageContext.request.pathInfo}/teacher?id=" + groupId;
        })
        .on('click', '.subject', function () {
            var groupId = $(this).closest('tr').find('td:eq(0)').text();
            document.location.href = "${pageContext.request.pathInfo}/subject?id=" + groupId;
        })
        .on('click', '.t-subject', function () {
            var groupId = $(this).data('val');
            document.location.href = "${pageContext.request.pathInfo}/subject?id=" + groupId;
        });
</script>
</body>
</html>
