<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2021
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="/products?action=create">Create a product</a></h3>
<p>
<form method="get" action="/products">
    <input type="text" name="key"> <button>Find by name</button>
</form></p>
<table border="1" cellpadding="5">
    <caption><h2>List of products</h2></caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Category</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="i" begin="0" end="${products.size() - 1}">
        <tr>
            <td>${products.get(i).id}</td>
            <td>${products.get(i).name}</td>
            <td>${products.get(i).price}</td>
            <td>${products.get(i).quantity}</td>
            <td>${products.get(i).color}</td>
            <td>${categories.get(i).name}</td>
            <td><a href="/products?action=edit&id=${products.get(i).id}">Edit</a></td>
            <td><a onclick="return confirm('Are you sure?')"
                   href="/products?action=delete&id=${products.get(i).id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
