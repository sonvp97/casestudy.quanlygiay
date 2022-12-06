package oder;

public class OrderDetails {
    private int idOderDetailsl;
    private int oderId;
    private int idShoe;

    private int price;
    private int quantityOder;

    public OrderDetails() {
    }

    public OrderDetails(int idOderDetailsl, int oderId, int idShoe, int quantityOder) {
        this.idOderDetailsl = idOderDetailsl;
        this.oderId = oderId;
        this.idShoe = idShoe;
        this.quantityOder = quantityOder;
    }

    public OrderDetails(int idOderDetailsl, int oderId, int idShoe,int price, int quantityOder) {
        this.idOderDetailsl = idOderDetailsl;
        this.oderId = oderId;
        this.idShoe = idShoe;
        this.quantityOder = quantityOder;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public OrderDetails(int oderId, int idShoe, int quantityOder) {
        this.oderId = oderId;
        this.idShoe = idShoe;
        this.quantityOder = quantityOder;
    }

    public OrderDetails(int idShoe, int quantityOder) {
        this.idShoe = idShoe;
        this.quantityOder = quantityOder;
    }

    public int getIdOderDetailsl() {
        return idOderDetailsl;
    }

    public void setIdOderDetailsl(int idOderDetailsl) {
        this.idOderDetailsl = idOderDetailsl;
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

    public int getQuantityOder() {
        return quantityOder;
    }

    public void setQuantityOder(int quantityOder) {
        this.quantityOder = quantityOder;
    }
}
