<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/8/2021
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="/blogs?action=create">Create a blog</a></h3>
<table border="1" cellpadding="5">
    <caption><h2>List of blogs</h2></caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Content</th>
        <th>Category</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="i" begin="0" end="${blogs.size() - 1}">
        <tr>
            <td>${blogs.get(i).id}</td>
            <td>${blogs.get(i).name}</td>
            <td>${blogs.get(i).content}</td>
            <td>${categories.get(i).name}</td>
            <td><a href="/blogs?action=edit&id=${blogs.get(i).id}">Edit</a></td>
            <td><a onclick="return confirm('Are you sure?')"
                   href="/blogs?action=delete&id=${blogs.get(i).id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
