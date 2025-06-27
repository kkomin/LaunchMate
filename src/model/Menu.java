package model;

// id, name, price
public class Menu {
    private int id;
    private String name;
    private int price;

    public Menu(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
