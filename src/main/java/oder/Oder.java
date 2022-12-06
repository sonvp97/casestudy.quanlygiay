package oder;

import java.util.ArrayList;
import java.util.List;

public class Oder {
    private int idOder;
    private int id;
    private String date;
    private int status;

    private List<OrderDetails> orderDetailsList = new ArrayList<>();

    public Oder() {
    }

    public Oder(int idOder, int id, String date, int status) {
        this.idOder = idOder;
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public Oder(int idOder, int id, String date) {
        this.idOder = idOder;
        this.id = id;
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdOder() {
        return idOder;
    }

    public void setIdOder(int idOder) {
        this.idOder = idOder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }
}
