package christmas.domain;

public class Order {
    private Food food;
    private int quantity;

    public Order(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "food=" + food +
                ", quantity=" + quantity +
                '}';
    }
}
