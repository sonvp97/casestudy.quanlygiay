package controller;

import oder.Oder;
import oder.OrderDetails;
import product.Shoe;
import service.OderService;
import service.OderServiceDAO;
import service.ShoeService;
import service.ShoeServiceDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

@WebServlet(name = "OderServlet", value = "/Oder")
public class OderServlet extends HttpServlet {
    OderService oderService = new OderServiceDAO();
    ShoeService shoeService = new ShoeServiceDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "more":
                showAdd(request,response);
                break;
            case "remove":
                showRemove(request,response);
                break;
            default:
                showCart(request,response);
                break;
        }
    }

    private void showRemove(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idShoe"));
        oderService.removeProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void showCart(HttpServletRequest request, HttpServletResponse response) {
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
        List<OrderDetails> list = oderService.groupByOrderDetails(oder.getIdOder());
        request.setAttribute("cart",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showAdd(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idShoe"));
        oderService.addProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
