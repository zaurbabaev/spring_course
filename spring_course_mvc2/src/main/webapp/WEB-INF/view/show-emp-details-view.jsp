<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show details</title>
</head>
<a href="/spring_course_mvc/employee">Home</a>
<br>
<body>
<h3>Dear Employee, you are WELCOME!!!</h3>

<br>
<br>
<%--Your name: ${param.employeeName}--%>
Your name: ${employee.name}
<br><br>

Your surname: ${employee.surname}
<br><br>

Your salary: ${employee.salary}
<br><br>

Your department: ${employee.department}
<br><br>

Your car: ${employee.carBrand}
<br><br>
Language(s):
<ul>

    <c:forEach var="lang" items="${employee.languages}">
        <li> ${lang} </li>
    </c:forEach>

</ul>
</body>
</html>
