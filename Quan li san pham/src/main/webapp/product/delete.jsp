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
        <legend><h3>Delete Product</h3></legend>
        <table>
            <tr>
                <td>Name:</td>
                <td>${sanPhamXoa.name}</td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>${sanPhamXoa.price}</td>
            </tr>
            <tr>
                <td>Are you sure?</td>
                <td><input type="submit" value="Delete"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
