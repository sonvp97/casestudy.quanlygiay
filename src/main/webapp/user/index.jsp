<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS TUF GAMING
  Date: 12/4/2022
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/includes/head.jsp" %>
    <style>
        img {
            height: 260px;
            width: 208px;
        }

        .row {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
</head>
<body>
<%@include file="/includes/nav.jsp" %>
<div class="container">
    <div class="card-header my-3">All Products
        <a href="/User?action=in"><button type="button" class="btn btn-light">Sort price increase</button></a>
        <a href="/User?action=up"><button type="button" class="btn btn-light">Sort price reduction</button></a>
    </div>
    <div class="row">
        <c:forEach items='${requestScope["list"]}' var="p">
            <a href="/User?action=view&&id=${p.getId()}&&email=${requestScope["email"].getEmail()}">
                <div class="col-md-3 my-3">
                    <div class="card w-100">
                        <img class="card-img-top" src="image/${p.getImg()}"
                             alt="Card image cap">
                        <div class="card-body" >
                            <h5 class="card-title">${p.getName()}</h5>
                            <h6 class="price">Price: ${p.getPrice()} </h6>
                            <h6 class="category">Brand: ${p.getBrand()}</h6>
                            <div class="mt-3 d-flex justify-content-between">
                                <a class="btn btn-dark" href="/Oder?action=null&&idShoe=${p.getId()}&&idUser=${requestScope["email"].getId()}&&email=${requestScope["email"].getEmail()}">Add to Cart</a> <a
                                    class="btn btn-primary" href="order-now?quantity=1&id=${p.getId()}">Buy Now</a>
                            </div>
                        </div>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>
<%@include file="/includes/footer.jsp" %>
</body>
</html>
