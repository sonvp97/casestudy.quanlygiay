<%--
  Created by IntelliJ IDEA.
  User: ASUS TUF GAMING
  Date: 12/5/2022
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/includes/head.jsp" %>
    <link rel="stylesheet" href="css.css">
</head>
<%@include file="/includes/nav.jsp" %>
<body>
<c:set value='${requestScope["view"]}' var="v"/>
<div class="container">
    <div class="card">
        <div class="container-fliud">
            <div class="wrapper row">
                <div class="preview col-md-6">
                    <div class="preview-pic tab-content">
                        <div class="tab-pane active" id="pic-1"><img src="image/${v.getImg()}"/></div>
                    </div>
                </div>
                <div class="details col-md-6 d-flex flex-column justify-content-center" >
                    <h3 class="product-title">Shoes fashion</h3>
                    <h4 class="name"> <span>${v.getName()}</span></h4>
                    <p class="product-description">${v.getDescribe()}</p>
                    <h4 class="price">current price: <span>${v.getPrice()}</span></h4>
                    <p class="vote"></p>
                    <h5 class="sizes">sizes:${v.getSize()}
                    </h5>
                    <div class="action">
                        <button class="add-to-cart btn btn-default" type="button">Add to cart</button>
                        <button class="like btn btn-default" type="button"><span class="fa fa-heart">Buy now</span>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/includes/footer.jsp" %>
</body>
</html>
