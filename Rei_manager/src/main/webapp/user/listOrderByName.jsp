<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/1/2021
  Time: 8:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User Management</h1>
<p><a href="/users?action=create">Create a user</a></p>
<p><a href="/users?action=findByName">Find user by name</a></p>
<p><a href="/users?action=findByCountry">Find user by country</a></p>
<p><a href="/users">Back to list</a></p>
<table border="1" cellpadding="5">
    <caption><h2>Order List of User by name</h2></caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>View</th>
    </tr>
    <c:forEach var="user" items="${listUserOrderByName}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td><a href="/users?action=edit&id=${user.id}">Edit</a></td>
            <td><a href="/users?action=delete&id=${user.id}">Delete</a></td>
            <td><a href="/users?action=view&id=${user.id}">View</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
