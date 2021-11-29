<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/29/2021
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <fieldset style="width: 300px">
        <legend><h3>Edit Product</h3></legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name" value="${sanPhamSua.name}"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" id="price" value="${sanPhamSua.price}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Edit"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
