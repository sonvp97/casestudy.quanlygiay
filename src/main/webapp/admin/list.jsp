<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS TUF GAMING
  Date: 12/3/2022
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Shoe</title>
    <style>
        img{
            width: 40px;
            height: 40px;
        }
    </style>
</head>
<body>
<p><a href="/shoe?action=sort">Sort By Price</a></p>
<p><a href="/shoe?action=add">Add Product</a></p>
<form method="post" action="/shoe?action=search">
    <table>
        <tr>
            <td><input type="text" name="name"></td>
            <td><input type="submit" value="Search By Name"></td>
        </tr>
    </table>
</form>
<table border="1">

    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Image</td>
    </tr>
    <c:forEach items='${requestScope["list"]}' var="list">
    <tr>
        <td>${list.getId()}</td>
        <td>${list.getName()}</td>
        <td>${list.getPrice()}</td>
        <td><img src="image/${list.getImg()}"></td>
        <td><a href="/shoe?action=edit&id=${list.getId()}">Edit</a></td>
        <td><a href="/shoe?action=delete&id=${list.getId()}">Delete</a></td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
