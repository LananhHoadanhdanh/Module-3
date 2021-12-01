<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/1/2021
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Delete User?</h2>
<form method="post">
    <table style="text-align: left"  cellpadding="5">
        <tr>
            <th>Id: </th>
            <td>${userDel.id}</td>
        </tr>
        <tr>
            <th>Name: </th>
            <td>${userDel.name}</td>
        </tr>
        <tr>
            <th>Email: </th>
            <td>${userDel.email}</td>
        </tr>
        <tr>
            <th>Country: </th>
            <td>${userDel.country}</td>
        </tr>
        <tr>
            <th>Are you sure?</th>
            <td><button>Yes</button></td>
        </tr>
    </table>
</form>
<a href="/users"><h3>Back to user list</h3></a>
</body>
</html>
