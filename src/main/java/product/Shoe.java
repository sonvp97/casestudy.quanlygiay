package product;

public class Shoe {
    private int id;
    private String name;
    private String describe;
    private double price;
    private String brand;
    private int size;
    private int quantity;
    private String img;

    public Shoe() {
    }

    public Shoe(int id, String name, String describe, double price, String brand, int size, int quantity, String img) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.brand = brand;
        this.size = size;
        this.quantity = quantity;
        this.img = img;
    }

    public Shoe(String name, String describe, double price, String brand, int size, int quantity, String img) {
        this.name = name;
        this.describe = describe;
        this.price = price;
        this.brand = brand;
        this.size = size;
        this.quantity = quantity;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
