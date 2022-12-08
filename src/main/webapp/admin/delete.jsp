<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS TUF GAMING
  Date: 12/4/2022
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Shoe</title>
    <style>
        img{
            width: 80px;
            height: 80px;
        }
    </style>
</head>
<body>
<h1><a href="/shoe">Back to list product</a></h1>
<form method="post">
    <fieldset>
        <legend>Delete Shoe</legend>
        <table>
            <tr>
                <td>Id</td>
                <td><input type="text" value='${requestScope["shoe"].getId()}' disabled></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" value='${requestScope["shoe"].getName()}' disabled></td>
            </tr>
            <tr>
                <td>Describe</td>
                <td><input type="text" value='${requestScope["shoe"].getDescribe()}' disabled></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="number" value='${requestScope["shoe"].getPrice()}' disabled></td>
            </tr>
            <tr>
                <td>Brand</td>
                <td><input type="text" value='${requestScope["shoe"].getBrand()}' disabled></td>
            </tr>
            <tr>
                <td>Size</td>
                <td><input type="number" value='${requestScope["shoe"].getSize()}' disabled></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><input type="text" value='${requestScope["shoe"].getQuantity()}' disabled></td>
            </tr>
            <tr>
                <td>Image</td>
                <td><img src="image/${requestScope["shoe"].getImg()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Delete"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
