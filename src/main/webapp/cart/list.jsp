<%@ page import="product.Shoe" %>
<%@ page import="oder.Oder" %>
<%@ page import="oder.OrderDetails" %>
<%@ page import="java.util.List" %>
<%@ page import="service.*" %>
<%@ page import="oder.OderNew" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS TUF GAMING
  Date: 12/6/2022
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <%@include file="/includes/head.jsp" %>
</head>
<body>
<%@include file="/includes/nav.jsp" %>
<div class="container">
  <div class="row">
    <div class="col-sm-12 col-md-10 col-md-offset-1">
      <table class="table table-hover">
        <thead>
        <tr>
          <th>Product</th>
          <th>Quantity</th>
          <th class="text-center">Price</th>
          <th class="text-center">Total</th>
          <th> </th>
        </tr>
        </thead>
        <tbody>
<%--            Oder oder = oderService.searchByIdOder(idUser);--%>
<%--            boolean check= false;--%>
<%--            if(oder==null){--%>
<%--              oderService.addOder(idUser);--%>
<%--              oder = oderService.searchByIdOder(idUser);--%>
<%--              check =true;--%>
<%--            }--%>
<%--            List<OrderDetails> list = oderService.groupByOrderDetails(oder.getIdOder());--%>
<%--            if(list.isEmpty()){--%>
<%--              oderService.removeOder(oder.getIdOder());--%>
<%--            }--%>
<%--            for (OrderDetails b : list){--%>
<%--              if(b.getQuantityOder()>0){--%>
<%--                check=true;--%>
<%--              }--%>
<%--            }--%>
<%--            if(check){--%>
<%--              oderService.addOderDetails(oder.getIdOder(),idShoe);--%>
<%--            }--%>
<%--          %>--%>
<%--          <%--%>
<%--          for (OrderDetails o : list){--%>
<%--            Shoe shoe = shoeService.findById(o.getIdShoe());--%>
<%--          %><%--%>
<%--          int total = (int) (shoe.getPrice()*o.getQuantityOder());--%>
<%--          %>--%>
<%
  OderService oderService = new OderServiceDAO();
  ShoeService shoeService = new ShoeServiceDAO();
  int idUser = Integer.parseInt(request.getParameter("idUser"));
  int idShoe = Integer.parseInt(request.getParameter("idShoe"));
  Oder oder = oderService.searchByIdOder(idUser);
  if(oder==null){
    oderService.addOder(idUser);
    oder = oderService.searchByIdOder(idUser);
    oderService.addOderDetails(oder.getIdOder(),idShoe);

  }else {
    oderService.addOderDetails(oder.getIdOder(),idShoe);
  }
  List<OderNew> list = oderService.groupByOrderDetails(oder.getIdOder());
  double subtotal = 0;
  for (OderNew o : list){
            Shoe shoe = shoeService.findById(o.getIdShoe());
            subtotal+= shoe.getPrice()*o.getQuantity();
%>
        <tr>
          <td class="col-sm-8 col-md-6">
            <div class="media">
              <a class="thumbnail pull-left" href="#"> <img class="media-object" src="image/<%=shoe.getImg()%>" style="width: 72px; height: 72px;"> </a>
              <div class="media-body">
                <h4 class="media-heading"><a href="#"><%=shoe.getName()%></a></h4>
                <h5 class="media-heading"> by <a href="#"><%=shoe.getBrand()%></a></h5>
                <span>Status: </span><span class="text-success"><strong><%=shoe.getQuantity()%></strong></span>
              </div>
            </div></td>
          <td class="col-sm-1 col-md-1" style="text-align: center">
            <input type="email" class="form-control" id="exampleInputEmail1" value="<%=o.getQuantity()%>">
          </td>
          <td class="col-sm-1 col-md-1 text-center"><strong><%=shoe.getPrice()%></strong></td>
          <td class="col-sm-1 col-md-1 text-center"><strong><%=o.getTotal()%></strong></td>
          <td class="col-sm-1 col-md-1">
            <a href="/Oder?action=more&&idShoe=<%=shoe.getId()%>&&idUser=${requestScope["email"].getId()}&&email=${requestScope["email"].getEmail()}" class="glyphicon glyphicon-remove" >Add Product</a>
            <a href="/Oder?action=remove&&idShoe=<%=shoe.getId()%>&&idUser=${requestScope["email"].getId()}&&email=${requestScope["email"].getEmail()}" class="glyphicon glyphicon-remove" >Remove</a>
        </tr>
        <%
          }
        %>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td><h5>Subtotal</h5></td>
          <td class="text-right"><h5><strong><%=subtotal%></strong></h5></td>
        </tr>
        <tr>
          <td>   </td>
          <td>   </td>
          <td>   </td>
          <td>
            <button type="button" class="btn btn-default">
              <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
            </button></td>
          <td>
            <button type="button" class="btn btn-success">
              Checkout <span class="glyphicon glyphicon-play"></span>
            </button></td>
        </tr>

        </tbody>
      </table>
    </div>
  </div>
</div>
<%@include file="/includes/footer.jsp" %>
</body>
</html>
