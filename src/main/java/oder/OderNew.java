package oder;

public class OderNew {
    private int oderId;
    private int idShoe;
    private int quantity;
    private String nameShoe;
    private double price;
    private double total;

    public OderNew(int oderId, int idShoe, int quantity, String nameShoe, double price, double total) {
        this.oderId = oderId;
        this.idShoe = idShoe;
        this.quantity = quantity;
        this.nameShoe = nameShoe;
        this.price = price;
        this.total = total;
    }

    public int getOderId() {
        return oderId;
    }

    public void setOderId(int oderId) {
        this.oderId = oderId;
    }

    public int getIdShoe() {
        return idShoe;
    }

    public void setIdShoe(int idShoe) {
        this.idShoe = idShoe;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameShoe() {
        return nameShoe;
    }

    public void setNameShoe(String nameShoe) {
        this.nameShoe = nameShoe;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
