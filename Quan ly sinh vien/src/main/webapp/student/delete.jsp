<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/30/2021
  Time: 3:50 PM
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
        <legend><h3>Delete student</h3></legend>
        <table>
            <tr>
                <td>Id:</td>
                <td>${studentDelete.id}</td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>${studentDelete.name}</td>
            </tr>
            <tr>
                <td>Math score:</td>
                <td>${studentDelete.mathScore}</td>
            </tr>
            <tr>
                <td>Physical score:</td>
                <td>${studentDelete.physicalScore}</td>
            </tr>
            <tr>
                <td>Chemistry score:</td>
                <td>${studentDelete.chemistryScore}</td>
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
