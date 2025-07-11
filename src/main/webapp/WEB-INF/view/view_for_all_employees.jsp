<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: iakon
  Date: 25.12.2024
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Information for all employees</h3>
<br><br>

<security:authorize access="hasRole('HR')">
    <input type="button" value="Salary"
           onclick="window.location.href = 'hr_info'">
    Only for HR stuff
</security:authorize>
<br><br>

<security:authorize access="hasRole('MANAGER')">
    <input type="button" value="Performance"
           onclick="window.location.href = 'manager_info'">
    Only for Managers
</security:authorize>

</body>
</html>
