<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/30/2021
  Time: 4:06 PM
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
        <legend><h3>Edit Student</h3></legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name" value="${studentEdit.name}"></td>
            </tr>
            <tr>
                <td>Math score:</td>
                <td><input type="number" name="mathScore" value="${studentEdit.mathScore}"></td>
            </tr>
            <tr>
                <td>Physical score:</td>
                <td><input type="number" name="physicalScore" value="${studentEdit.physicalScore}"></td>
            </tr>
            <tr>
                <td>Chemistry score:</td>
                <td><input type="number" name="chemistryScore" value="${studentEdit.chemistryScore}"></td>
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
