<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ask details</title>
</head>
<body>
<h2>Dear Employee, Please enter your details</h2>
<br>
<br>


<form:form action="showDetails" modelAttribute="employee" method="post">
    Name: <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>

    Surname: <form:input path="surname"/>
    <form:errors path="surname"/>

    <br><br>

    Salary: <form:input path="salary"/>
    <form:errors path="salary"/>

    <br><br>

    <%--    Department: <form:select path="department">--%>
    <%--    <form:option value="Information Technology" label="IT"/>--%>
    <%--    <form:option value="Sales" label="Sales"/>--%>
    <%--    <form:option value="Human Resources" label="HR"/>--%>
    <%--</form:select>--%>

    Department: <form:select path="department">
    <form:options items="${employee.departments}"/>
</form:select>
    <br><br>
    Phone number: <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br><br>
    Phone email: <form:input path="email"/>
    <form:errors path="email"/>
    <br><br>
    Which car do you want?
    <%--    BMW <form:radiobutton path="carBrand" value="BMW"/>--%>
    <%--    AUDI <form:radiobutton path="carBrand" value="Audi"/>--%>
    <%--    MB <form:radiobutton path="carBrand" value="Mercedes-Benz"/>--%>

    <form:radiobuttons path="carBrand" items="${employee.carBrandList}"/>
    <form:errors path="carBrand"/>

    <br><br>
    Foreign language(s):
    <%--    EN <form:checkbox path="languages" value="English"/>--%>
    <%--    FR <form:checkbox path="languages" value="French"/>--%>
    <%--    RU <form:checkbox path="languages" value="Russian"/>--%>
    <form:checkboxes path="languages" items="${employee.languageList}"/>
    <form:errors path="languages"/>


    <br><br>
    <input type="submit" value="OK">

</form:form>

</body>
</html>
