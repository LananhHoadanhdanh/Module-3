<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/1/2021
  Time: 8:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create a user</h1>
<form method="post">
    <table  cellpadding="5" style="text-align: left">
        <tr>
            <th>Name:</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>Email:</th>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <th>Country:</th>
            <td><input type="text" name="country"></td>
        </tr>
        <tr>
            <th></th>
            <td><input type="submit" value="Create"></td>
        </tr>
    </table>
</form>
<a href="/users"><h3>Back to user list</h3></a>
</body>
</html>
