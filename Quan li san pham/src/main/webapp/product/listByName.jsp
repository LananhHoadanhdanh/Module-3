<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/30/2021
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/products">Back to Product list</a></p>
<table border="1px" style="border-collapse: collapse">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
    </tr>
    <c:forEach items='${danhSachTheoTen}' var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
