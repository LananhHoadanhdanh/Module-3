<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/30/2021
  Time: 10:11 AM
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
        <legend><h3>Find Product by Price</h3></legend>
        <table>
            <tr>
                <td>Min Price: </td>
                <td><input type="text" name="minPrice" id="minPrice"></td>
            </tr>
            <tr>
                <td>Max Price: </td>
                <td><input type="text" name="maxPrice" id="maxPrice"></td>
            </tr>
            <tr>
                <td></td>
                <td><button>Find</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
