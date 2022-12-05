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
</head>
<body>
<h1><a href="/shoe">Back to list product</a></h1>
<table border="1">
  <tr>
    <td>Id</td>
    <td>Name</td>
    <td>Price</td>
    <td>Image</td>
  </tr>
  <c:forEach items='${requestScope["search"]}' var="search">
    <tr>
      <td>${search.getId()}</td>
      <td>${search.getName()}</td>
      <td>${search.getPrice()}</td>
      <td><img src="image/${search.getImg()}"></td>
      <td><a href="/shoe?action=edit&id=${search.getId()}">Edit</a></td>
      <td><a href="/shoe?action=delete&id=${search.getId()}">Delete</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
