package controller;

import product.Shoe;
import service.ShoeService;
import service.ShoeServiceDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShoeServlet", value = "/shoe")
public class ShoeServlet extends HttpServlet {
    ShoeService shoeService = new ShoeServiceDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddShoe(request, response);
                break;
            case "delete":
                showDeleteShoe(request, response);
                break;
            case "edit":
                showEditShoe(request, response);
                break;
            case "sort":
                showSortShoe(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                AddShoe(request, response);
                break;
            case "delete":
                deleteShoe(request, response);
                break;
            case "edit":
                updateShoe(request, response);
                break;
            case "search":
                searchByName(request,response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("name");
        List<Shoe> list = shoeService.findByName(search);
        request.setAttribute("search",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/search.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateShoe(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String describe = request.getParameter("describe");
        double price = Double.parseDouble(request.getParameter("price"));
        String brand = request.getParameter("brand");
        int size = Integer.parseInt(request.getParameter("size"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String img = request.getParameter("img");
        Shoe shoe = new Shoe(id, name, describe, price, brand, size, quantity, img);
        shoeService.update(id,shoe);
        try {
            response.sendRedirect("/shoe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    String name = request.getParameter("name");
//    String describe = request.getParameter("describe");
//    double price = Double.parseDouble(request.getParameter("price"));
//    String brand = request.getParameter("brand");
//    int size = Integer.parseInt(request.getParameter("size"));
//    int quantity = Integer.parseInt(request.getParameter("quantity"));
//    String img = request.getParameter("img");
//    Shoe shoe = new Shoe(id,name,describe,price,brand,size,quantity,img);

    private void deleteShoe(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        shoeService.remove(id);
        try {
            response.sendRedirect("/shoe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditShoe(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Shoe shoe = shoeService.findById(id);
        request.setAttribute("update", shoe);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void AddShoe(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String describe = request.getParameter("describe");
        double price = Double.parseDouble(request.getParameter("price"));
        String brand = request.getParameter("brand");
        int size = Integer.parseInt(request.getParameter("size"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String img = request.getParameter("img");
        Shoe shoe = new Shoe(name, describe, price, brand, size, quantity, img);
        shoeService.add(shoe);
        try {
            response.sendRedirect("/shoe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAddShoe(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/add.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Shoe> list = shoeService.findAll();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteShoe(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Shoe shoe = shoeService.findById(id);
        request.setAttribute("shoe", shoe);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showSortShoe(HttpServletRequest request, HttpServletResponse response) {
        List<Shoe> list = shoeService.sortByPrice();
        request.setAttribute("sort",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/sort.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
