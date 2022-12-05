<%--
  Created by IntelliJ IDEA.
  User: ASUS TUF GAMING
  Date: 12/4/2022
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Shoe</title>
</head>
<body>
<h1><a href="/shoe">Back to list product</a></h1>
<form method="post">
  <fieldset>
    <legend>Update Shoe</legend>
    <table>
      <tr>
        <td>Id</td>
        <td><input type="text" value='${requestScope["update"].getId()}' name="id" disabled></td>
      </tr>
      <tr>
        <td>Name</td>
        <td><input type="text" value='${requestScope["update"].getName()}' name="name"></td>
      </tr>
      <tr>
        <td>Describe</td>
        <td><input type="text" value='${requestScope["update"].getDescribe()}' name="describe"></td>
      </tr>
      <tr>
        <td>Price</td>
        <td><input type="number" value='${requestScope["update"].getPrice()}' name="price"></td>
      </tr>
      <tr>
        <td>Brand</td>
        <td><input type="text" value='${requestScope["update"].getBrand()}' name="brand"></td>
      </tr>
      <tr>
        <td>Size</td>
        <td><input type="number" value='${requestScope["update"].getSize()}' name="size"></td>
      </tr>
      <tr>
        <td>Quantity</td>
        <td><input type="text" value='${requestScope["update"].getQuantity()}' name="quantity"></td>
      </tr>
      <tr>
        <td>Image</td>
        <td><input type="file" name="img"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Update"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
