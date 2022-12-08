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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
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
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Image</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items='${requestScope["list"]}' var="list">
    <tr>
        <td scope="row">${list.getId()}</td>
        <td>${list.getName()}</td>
        <td>${list.getPrice()}</td>
        <td><img src="image/${list.getImg()}"></td>
        <td><a href="/shoe?action=edit&id=${list.getId()}"><button type="button" class="btn btn-light">Edit</button></a></td>
        <td><a href="/shoe?action=delete&id=${list.getId()}"><button type="button" class="btn btn-primary">Delete</button></a></td>
    </tr>
</c:forEach>
    </tbody>
</table>

</body>
</html>
