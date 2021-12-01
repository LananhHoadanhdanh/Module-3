<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/1/2021
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User's Information</h1>
<table cellpadding="5" style="text-align: left">
    <tr>
        <th>Id:</th>
        <td>${userInfor.id}</td>
    </tr>
    <tr>
        <th>Name:</th>
        <td>${userInfor.name}</td>
    </tr>
    <tr>
        <th>Email:</th>
        <td>${userInfor.email}</td>
    </tr>
    <tr>
        <th>Country:</th>
        <td>${userInfor.country}</td>
    </tr>
</table>
<a href="/users"><h3>Back to user list</h3></a>
</body>
</html>
