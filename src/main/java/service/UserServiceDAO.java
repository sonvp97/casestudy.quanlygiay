package service;

import product.Shoe;
import user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceDAO implements UserService{
    private static final String URL = "jdbc:mysql://localhost:3306/demo3";
    private static final String USER = "root";
    private static final String PASS = "admin";
    private static final String SELECT_ALL_USER = "select * from user;";
    private static final String SELECT_BY_ID = "select * from user where id = ?;";
    private static final String SELECT_ALL_SHOE = "select * from shoe;";
    private static final String INSERT_USER = "insert into user(name,age,address,email,pass) values (?,?,?,?,?);";
    Connection connection = null;

    protected Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);)
        {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String pass = rs.getString("pass");
                User user = new User(id,name,age,address,email,pass);
                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(User user) {
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);)
        {preparedStatement.setString(1, user.getName());
        preparedStatement.setInt(2, user.getAge());
        preparedStatement.setString(3, user.getAddress());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, user.getPass());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);)
        {preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String pass = rs.getString("pass");
                user = new User(id,name,age,address,email,pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean checkUser(String email, String pass) {
        List<User> list = findAll();
        for(User u : list){
            if (u.getEmail().toLowerCase().equals(email.toLowerCase())&& u.getPass().toLowerCase().equals(pass.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Shoe> findAllProduct() {
        List<Shoe> list = new ArrayList<>();
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SHOE);)
        {ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String describe = rs.getString("describe");
                double price = rs.getDouble("price");
                String brand = rs.getString("brand");
                int size = rs.getInt("size");
                int quantity = rs.getInt("quantity");
                String img = rs.getString("img");
                Shoe shoe = new Shoe(id, name, describe, price, brand, size, quantity, img);
                list.add(shoe);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
