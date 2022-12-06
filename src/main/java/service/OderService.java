package service;

import oder.Oder;
import oder.OrderDetails;

import java.util.List;

public interface OderService {
    List<Oder> getAllOder();
    List<OrderDetails> getAllOderDetails();
    List<OrderDetails> searchByIdOderDetails(int idOder);
    void addOder(int idUser);
    void addOderDetails(int idUser,int idShoe);
    Oder searchByIdOder(int idOder);
    List<OrderDetails> groupByOrderDetails(int idUser);
    void addProduct(int idShoe);
    void removeProduct(int idShoe);
    void removeOder(int idOder);
}
