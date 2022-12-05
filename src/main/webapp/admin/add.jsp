<%--
  Created by IntelliJ IDEA.
  User: ASUS TUF GAMING
  Date: 12/3/2022
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h1>Add Product</h1>
<p><a href="/shoe">Back to Shoe</a></p>
<form method="post">
  <fieldset>
    <legend>
      Add Shoe
    </legend>
    <table>
      <tr>
        <td>Name</td>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <td>Describe</td>
        <td><input type="text" name="describe"></td>
      </tr>
      <tr>
        <td>Price</td>
        <td><input type="number" name="price"></td>
      </tr>
      <tr>
        <td>Brand</td>
        <td><input type="text" name="brand"></td>
      </tr>
      <tr>
        <td>Size</td>
        <td><input type="number" name="size"></td>
      </tr>
      <tr>
        <td>Quantity</td>
        <td><input type="number" name="quantity"></td>
      </tr>
      <tr>
        <td>Image</td>
        <td><input type="file" name="img"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="add"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
