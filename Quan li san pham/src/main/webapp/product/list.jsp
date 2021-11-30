<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/29/2021
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product List</h1>
<p><a href="/products?action=create">Create a product</a></p>
<p><a href="/products?action=findByName">Find product by Name</a></p>
<p><a href="/products?action=findByPrice">Find product by Price</a></p>
<table border="1px" style="border-collapse: collapse">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Edit</td>
        <td>Delete</td>
        <td>View</td>
    </tr>
    <c:forEach items='${danhSach}' var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td><a href="/products?action=edit&id=${product.id}">Edit</a></td>
            <td><a href="/products?action=delete&id=${product.id}">Delete</a></td>
            <td><a href="/products?action=view&id=${product.id}">View</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
