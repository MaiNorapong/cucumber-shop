package ku.shop;

import io.cucumber.java.sl.In;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {

    private Map<String, Product> products;
    private Map<String, Integer> inventory;

    public ProductCatalog() {
        products = new HashMap<>();
        inventory = new HashMap<>();
    }

    public void addProduct(String name, double price) {
        products.put(name, new Product(name, price));
        inventory.put(name, 0);
    }

    public void addStock(String name, int amount) {
        inventory.put(name, inventory.get(name) + amount);
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public Integer getStock(Product product) {
        return inventory.get(product.getName());
    }
}
