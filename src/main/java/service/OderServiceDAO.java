package service;

import oder.Oder;
import oder.OderNew;
import oder.OrderDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OderServiceDAO implements OderService {
    private static final String URL = "jdbc:mysql://localhost:3306/demo3";
    private static final String USER = "root";
    private static final String PASS = "admin";
    private static final String SELECT_ALL_ODER = "select * from oder;";
    private static final String SELECT_ALL_ODER_DETAILS = "select * from oderDetails;";
    private static final String INSERT_ODER = "insert into oder(id,`date`,`status`) values(?,CURDATE(),0);";
    private static final String INSERT_ODER_DETAILS = "insert into orderdetails(oderId,idShoe,quantityOder) values(?,?,1);";
    private static final String SELECT_BY_ID_ODER = "select * from oderDetails where idOder = ?;";
//    private static final String GROUP_BY_ODER_DETAILS = "SELECT oderId,idShoe,SUM(quantityOder) as Quantity FROM orderdetails where oderId = ? GROUP BY idShoe;";
    private static final String SELECT_BY_ID_FALSE = "select * from oder where id = ?&&`status`=0;";
    private static final String ADD_PRODUCT = "delete from oderDetails where idShoe = ?;";
    private static final String DELETE_BY_ID = "delete from orderDetails where idShoe = ?;";
    private static final String GROUP_BY_ODER_DETAILS = "SELECT ord.oderId,s.idShoe,SUM(ord.quantityOder)as quantity,s.nameShoe,s.price,(s.price*SUM(ord.quantityOder)) as total FROM shoe s join orderdetails ord on s.idShoe=ord.idShoe join oder o on o.idOder=ord.oderId where oderId = ? GROUP BY idShoe;";
    private static final String DELETE_ORDERDETAILS = "delete from order where idOder = ?;";
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
    public List<Oder> getAllOder() {
        List<Oder> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ODER);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOder = rs.getInt("idOder");
                int idUser = rs.getInt("id");
                String date = rs.getString("date");
                Oder oder = new Oder(idOder, idUser, date);
                list.add(oder);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<OrderDetails> getAllOderDetails() {
        List<OrderDetails> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ODER_DETAILS);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOderDetails = rs.getInt("idOderDetails");
                int idOder = rs.getInt("idOder");
                int idShoe = rs.getInt("idShoe");
                int quantityOder = rs.getInt("quantityOder");
                OrderDetails orderDetails = new OrderDetails(idOderDetails, idOder, idShoe, quantityOder);
                list.add(orderDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<OrderDetails> searchByIdOderDetails(int idOder) {
        List<OrderDetails> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_ODER);) {
            preparedStatement.setInt(1, idOder);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOderDetails = rs.getInt("idOderDetails");
                int idOder1 = rs.getInt("idOder");
                int idShoe = rs.getInt("idShoe");
                int quantityOder = rs.getInt("quantityOder");
                OrderDetails orderDetails = new OrderDetails(idOderDetails, idOder1, idShoe, quantityOder);
                list.add(orderDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addOder(int idUser) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ODER);) {
            preparedStatement.setInt(1, idUser);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOderDetails(int idUser, int idShoe) {
        try (Connection connection = getConnection();
             PreparedStatement p = connection.prepareStatement(INSERT_ODER_DETAILS);) {
            p.setInt(1, idUser);
            p.setInt(2, idShoe);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Oder searchByIdOder(int idUser) {
        Oder oder = null;
        try (Connection connection = getConnection();
             PreparedStatement p = connection.prepareStatement(SELECT_BY_ID_FALSE);) {
            p.setInt(1, idUser);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                int idOder = rs.getInt("idOder");
                String date = rs.getString("date");
                int status = rs.getInt("status");
                oder = new Oder(idOder, idUser, date, status);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oder;
    }

    @Override
    public List<OderNew> groupByOrderDetails(int idOder) {
        List<OderNew> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement p = connection.prepareStatement(GROUP_BY_ODER_DETAILS);) {
            p.setInt(1, idOder);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                int oderId = rs.getInt("oderId");
                int idShoe = rs.getInt("idShoe");
                int quantity = rs.getInt("Quantity");
                String nameShoe = rs.getString("nameShoe");
                double price = rs.getDouble("price");
                double total = rs.getDouble("total");
//                OrderDetails orderDetails = new OrderDetails(idOder, idShoe, quantity);
                OderNew order = new OderNew(oderId,idShoe,quantity,nameShoe,price,total);
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addProduct(int idShoe) {
        try (Connection connection = getConnection();
        PreparedStatement p = connection.prepareStatement(ADD_PRODUCT);)
        {p.setInt(1,idShoe);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeProduct(int idShoe) {
        try (Connection connection = getConnection();
             PreparedStatement p = connection.prepareStatement(DELETE_BY_ID);)
        {p.setInt(1,idShoe);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeOder(int idOder) {
        try (Connection connection = getConnection();
             PreparedStatement p = connection.prepareStatement(DELETE_ORDERDETAILS);)
        {p.setInt(1,idOder);
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
