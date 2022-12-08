<%--
  Created by IntelliJ IDEA.
  User: ASUS TUF GAMING
  Date: 12/4/2022
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search By Name</title>
  <style>
    img{
      width: 40px;
      height: 40px;
    }
  </style>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>
<body>
<h1><a href="/shoe">Back to list product</a></h1>
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
  <c:forEach items='${requestScope["search"]}' var="search">
    <tr>
      <td scope="row">${search.getId()}</td>
      <td>${search.getName()}</td>
      <td>${search.getPrice()}</td>
      <td><img src="image/${search.getImg()}"></td>
      <td><a href="/shoe?action=edit&id=${search.getId()}"><button type="button" class="btn btn-light">Edit</button></a></td>
      <td><a href="/shoe?action=delete&id=${search.getId()}"><button type="button" class="btn btn-primary">Delete</button></a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
