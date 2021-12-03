<%--
  Created by IntelliJ IDEA.
  User: vieth
  Date: 12/2/2021
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit Product?</h2>
<form method="post">
    <table style="text-align: left"  cellpadding="5">
        <tr>
            <th>ID: </th>
            <td><input type="number" name="id" value="${suaSP.id}"></td>
        </tr>
        <tr>
            <th>Name: </th>
            <td><input type="text" name="name" value="${suaSP.name}"></td>
        </tr>
        <tr>
            <th>Price: </th>
            <td><input type="text" name="price" value="${suaSP.price}"></td>
        </tr>
        <tr>
            <th>Quantity: </th>
            <td><input type="text" name="quantity" value="${suaSP.quantity}"></td>
        </tr>
        <tr>
            <th>Are you sure?</th>
            <td><button>Send</button></td>
        </tr>
    </table>
</form>
<a href="/products"><h3>Back to product list</h3></a>
</body>
</html>