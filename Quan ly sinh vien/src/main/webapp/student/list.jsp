<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/30/2021
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Student List</h1>
<table border="1px" style="border-collapse: collapse">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Math Score</td>
        <td>Physical Score</td>
        <td>Chemistry Score</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${studentList}' var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td style="text-align: center">${student.mathScore}</td>
            <td style="text-align: center">${student.physicalScore}</td>
            <td style="text-align: center">${student.chemistryScore}</td>
            <td><a href="/students?action=edit&id=${student.id}">Edit</a></td>
            <td><a href="/students?action=delete&id=${student.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
