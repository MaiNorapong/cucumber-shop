package ku.shop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<OrderItem> items;
    private LocalDateTime date;
    private ProductCatalog inventory;

    public Order(ProductCatalog inventory, int id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
        this.inventory = inventory;
    }

    public Order(ProductCatalog inventory) {
        this.id = 0;
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
        this.inventory = inventory;
    }

    public void addItem(Product prod, int quantity) {
        Integer amountInStock = inventory.getStock(prod);
        if (amountInStock >= quantity) {
            items.add(new OrderItem(prod, quantity));
        }
        else {
            throw new IllegalOrderException(prod, quantity, amountInStock);
        }
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

}
