package service;

import product.Shoe;

import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class ShoeServiceDAO implements ShoeService {
    private static final String URL = "jdbc:mysql://localhost:3306/demo3";
    private static final String USER = "root";
    private static final String PASS = "admin";
    private static final String INSERT_SHOE = "insert into shoe(`name`,`describe`,price,brand,size,quantity,img) values (?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_SHOE = "select * from shoe;";
    private static final String SELECT_BY_ID_SHOE = "select * from shoe where id = ?;";
    private static final String DELETE_BY_ID_SHOE = "DELETE from shoe where id = ?;";
    private static final String SORT_BY_Price = "select *from shoe order by price;";
    private static final String SELECT_BY_NAME = "select * from shoe where name like ?;";
    private static final String UPDATE_BY_ID_SHOE = "update shoe set name = ?,`describe` = ?,price = ?,brand = ?,size = ?,quantity = ?,img = ? where id = ?;";
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
    public List<Shoe> findAll() {
        List<Shoe> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SHOE);) {
            ResultSet rs = preparedStatement.executeQuery();
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

    @Override
    public void add(Shoe shoe) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHOE);) {
            preparedStatement.setString(1, shoe.getName());
            preparedStatement.setString(2, shoe.getDescribe());
            preparedStatement.setDouble(3, shoe.getPrice());
            preparedStatement.setString(4, shoe.getBrand());
            preparedStatement.setInt(5, shoe.getSize());
            preparedStatement.setInt(6, shoe.getQuantity());
            preparedStatement.setString(7, shoe.getImg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Shoe findById(int id) {
        Shoe shoe = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_SHOE);) {
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String describe = rs.getString("describe");
                double price = rs.getDouble("price");
                String brand = rs.getString("brand");
                int size = rs.getInt("size");
                int quantity = rs.getInt("quantity");
                String img = rs.getString("img");
                shoe = new Shoe(id, name, describe, price, brand, size, quantity, img);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoe;
    }

    @Override
    public List<Shoe> findByName(String name) {
        List<Shoe> list = new ArrayList<>();
        Shoe shoe = null;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME);)
        {preparedStatement.setString(1, "%"+name+"%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                String describe = rs.getString("describe");
                double price = rs.getDouble("price");
                String brand = rs.getString("brand");
                int size = rs.getInt("size");
                int quantity = rs.getInt("quantity");
                String img = rs.getString("img");
                shoe = new Shoe(id, name1, describe, price, brand, size, quantity, img);
                list.add(shoe);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(int id, Shoe shoe) {
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID_SHOE);)
        {preparedStatement.setString(1, shoe.getName());
            preparedStatement.setString(2, shoe.getDescribe());
            preparedStatement.setDouble(3, shoe.getPrice());
            preparedStatement.setString(4, shoe.getBrand());
            preparedStatement.setInt(5, shoe.getSize());
            preparedStatement.setInt(6, shoe.getQuantity());
            preparedStatement.setString(7, shoe.getImg());
            preparedStatement.setInt(8, shoe.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID_SHOE);) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Shoe> sortByPrice() {
        List<Shoe> list = new ArrayList<>();
        Shoe shoe = null;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_Price);)
        {ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                String describe = rs.getString("describe");
                double price = rs.getDouble("price");
                String brand = rs.getString("brand");
                int size = rs.getInt("size");
                int quantity = rs.getInt("quantity");
                String img = rs.getString("img");
                shoe = new Shoe(id, name1, describe, price, brand, size, quantity, img);
                list.add(shoe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
