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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">SHOE SHOP</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/User">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="user/login.jsp">Login</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Cart
                </a>
                <%--        <div class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
                <%--          <a class="dropdown-item" href="#">Action</a>--%>
                <%--          <a class="dropdown-item" href="#">Another action</a>--%>
                <%--          <div class="dropdown-divider"></div>--%>
                <%--          <a class="dropdown-item" href="#">Something else here</a>--%>
                <%--        </div>--%>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="container">
    <div class="card-header my-3">All Products</div>
    <div class="row">
        <c:forEach items='${requestScope["list"]}' var="p">
            <a href="/User?action=view&&id=${p.getId()}">
                <div class="col-md-3 my-3">
                    <div class="card w-100">
                        <img class="card-img-top" src="image/${p.getImg()}"
                             alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">${p.getName()}</h5>
                            <h6 class="price">Price: ${p.getPrice()} </h6>
                            <h6 class="category">Brand: ${p.getBrand()}</h6>
                            <div class="mt-3 d-flex justify-content-between">
                                <a class="btn btn-dark" href="add-to-cart?id=${p.getId()}">Add to Cart</a> <a
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
