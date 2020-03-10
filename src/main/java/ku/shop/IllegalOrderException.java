package ku.shop;

public class IllegalOrderException extends RuntimeException {
    public IllegalOrderException(Product product, int amountAttempted, int amountInStock) {
        super("Customer wants to buy " + amountAttempted + " but only " +
                amountInStock + " items of product " + product + " is in stock.");
    }
}
