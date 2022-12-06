<%--
  Created by IntelliJ IDEA.
  User: ASUS TUF GAMING
  Date: 12/4/2022
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/includes/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">Register</div>
        <div class="card-body"></div>
        <form method="post">
            <div class="form-group">
                <label>Name</label>
                <input type="text" class="form-control" name="name" placeholder="Enter Your Name" required>
            </div>
            <div class="form-group">
                <label>Age</label>
                <input type="number" class="form-control" name="age" placeholder="Enter Your Age" required>
            </div>
            <div class="form-group">
                <label>Address</label>
                <input type="text" class="form-control" name="address" placeholder="Enter Your Address" required>
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="text" class="form-control" name="email" placeholder="Enter Your Email" required>
            </div>
            <c:if test='${requestScope["message1"] != null}'>
                <span class="message">${requestScope["message1"]}</span>
            </c:if>
            <div class="form-group">
                <label>Pass</label>
                <input type="password" class="form-control" name="pass" placeholder="*******" required>
            </div>
            <div class="text-center">
                     <a href="/user/login.jsp">Login</a>
                    <button type="submit" class="btn btn-primary">Create</button>
            </div>
        </form>
    </div>
</div>
<%@include file="/includes/footer.jsp" %>
</body>
</html>
