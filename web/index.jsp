<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="=text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <title>University</title>
</head>
<body>
<div class="container">
    <br/>
    <div class="row">
        <div class="col-md-12">
            <h2 align="center">University</h2>
        </div>
        <div class="col-md-12"></div>
    </div>
    <br/>
    <div class="col-md-12" align="center">
        <a class="btn btn-light" role="button" href="${pageContext.request.contextPath}/faculties">Faculties</a>
        <br/>
        <a class="btn btn-light" role="button" href="${pageContext.request.contextPath}/classrooms">Classrooms</a>
        <br/>
        <a class="btn btn-light" role="button" href="${pageContext.request.contextPath}/lessons">Schedule</a>
        <br/>
        <a class="btn btn-light" role="button" href="${pageContext.request.contextPath}/students">Students</a>
    </div>
</div>
</body>
</html>
