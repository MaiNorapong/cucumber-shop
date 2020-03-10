package ku.shop;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Before
    public void setup() {
        catalog = new ProductCatalog();
        order = new Order(catalog);
    }

    @Given("a product (.+) with price (.+) exists")
    public void a_product_with_price_exists(String name, double price) {
        catalog.addProduct(name, price);
    }

    @Given("an inventory has (.+) items of product (.+) in stock")
    public void a_product_has_in_stock(int amount, String name) {
        catalog.addStock(name, amount);
    }

    @When("I buy (.+) with quantity (.+)")
    public void i_buy_with_quantity(String name, int quant) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quant);
    }

    @Then("total should be (.+)")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

    @When("I try to buy (.+) with quantity (.+) I can't")
    public void i_should_not_be_able_to_buy_with_quantity(String name, int quant) {
        Product prod = catalog.getProduct(name);
        Exception exception = assertThrows(IllegalOrderException.class, () -> {
            order.addItem(prod, quant);
        });
        assertEquals("Customer wants to buy " + quant + " but only " + catalog.getStock(prod) +
                " items of product " + prod + " is in stock.", exception.getMessage());
    }
}

