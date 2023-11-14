package christmas.domain;

public class Food {
    private String name;
    private int price;
    private String Type;

    public Food(String name, int price, String type) {
        this.name = name;
        this.price = price;
        Type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return Type;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", Type='" + Type + '\'' +
                '}';
    }
}
