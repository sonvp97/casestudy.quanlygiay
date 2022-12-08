package controller;

import product.Shoe;
import service.ShoeService;
import service.ShoeServiceDAO;
import service.UserService;
import service.UserServiceDAO;
import user.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/User")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceDAO();
    ShoeService shoeService = new ShoeServiceDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "add":
                showAdd(request,response);
                break;
            case "view":
                showView(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "add":
                addUser(request,response);
                break;
            case "login":
                loginUser(request,response);
                break;
            case "search":
                searchByName(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        List<Shoe> list = shoeService.findByName(name);
        request.setAttribute("search",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/search.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        if(userService.checkUser(email,pass)&&!email.equals("admin")&&!pass.equals("admin")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/index.jsp");
            List<Shoe> list = userService.findAllProduct();
            request.setAttribute("list",list);
            User user = userService.searchByEmail(email);
            request.setAttribute("email",user);
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if(email.equals("admin")&&pass.equals("admin")){
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
        } else {
            request.setAttribute("message","Wrong password or username");
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/login.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        User user = new User(name,age,address,email,pass);
        userService.add(user);
        if(userService.searchByEmail(email)==null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/login.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/add.jsp");
            request.setAttribute("message1","Email already exists");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        if(action.equals("in")){
            List<Shoe> list = shoeService.sortByPrice();
            request.setAttribute("list",list);
        } else if(action.equals("up")){
            List<Shoe> list = shoeService.sortReduction();
            request.setAttribute("list",list);
        } else {
            List<Shoe> list = userService.findAllProduct();
            request.setAttribute("list",list);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/index.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showAdd(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/add.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showView(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        Shoe shoe = shoeService.findById(id);
        request.setAttribute("view",shoe);
        User user = userService.searchByEmail(email);
        request.setAttribute("email",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/view.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
