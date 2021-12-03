<%--
  Created by IntelliJ IDEA.
  product: vieth
  Date: 12/2/2021
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  product: Admin
  Date: 12/1/2021
  Time: 8:19 AM
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
<h1>Product Management</h1>
<p><a href="/products?act=create">Create a product</a></p>
<p><a href="/products?act=orderByQuantity">Order product by quantity</a></p>
<p><a href="/products">Back to list</a></p>
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
        <th>Edit</th>
        <th>Delete</th>
<%--        <th>View</th>--%>
    </tr>
    <c:forEach var="product" items="${dsSP}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td><a href="/products?act=edit&id=${product.id}">Edit</a></td>
            <td><a href="/products?act=delete&id=${product.id}">Delete</a></td>
            <td> <a onclick="return confirm('Are you sure?')"
                    href="/products?act=delete1&id=${product.id}">delete1</a></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>

