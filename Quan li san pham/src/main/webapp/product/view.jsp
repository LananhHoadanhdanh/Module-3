<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/30/2021
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/products">Back to Product List</a></p>
<fieldset style="width: 300px">
    <legend>Product's Information</legend>
    <table>
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Price</td>
        </tr>
        <tr>
            <td>${productView.id}</td>
            <td>${productView.name}</td>
            <td>${productView.price}</td>
        </tr>
    </table>
</fieldset>
</body>
</html>
