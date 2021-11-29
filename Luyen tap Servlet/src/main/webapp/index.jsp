<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/26/2021
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--  <form action="/product" method="post">--%>
<%--    <input type="text" name="description" placeholder="Description"> <br>--%>
<%--    <input type="text" name="price" placeholder="Price"> <br>--%>
<%--    <input type="text" name="percent" placeholder="Discount Percent"> <br>--%>
<%--    <input type="submit" id="submit" value="Calculate Discount">--%>
<%--  </form>--%>

<form method="get" action="/login">
  <div class="login">
    <h2>Login</h2>
    <input type="text" name="username" size="30"  placeholder="username"/> <br>
    <input type="password" name="password" size="30" placeholder="password" /> <br>
    <input type="submit" value="Sign in"/>
  </div>
</form>

<%--<h2>Currency Converter</h2>--%>
<%--<form action="/convert" method="post">--%>
<%--  <label>Rate: </label><br/>--%>
<%--  <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>--%>
<%--  <label>USD: </label><br/>--%>
<%--  <input type="text" name="usd" placeholder="USD" value="0"/><br/>--%>
<%--  <input type = "submit" id = "submit" value = "Converter"/>--%>
<%--</form>--%>

<%--<h2>Vietnamese Dictionary</h2>--%>
<%--<form action="/translate" method="post">--%>
<%--  <input type="text" name="txtSearch" placeholder="Enter your word: "/>--%>
<%--  <input type = "submit" id = "submit" value = "Search"/>--%>
<%--</form>--%>
  </body>
</html>
