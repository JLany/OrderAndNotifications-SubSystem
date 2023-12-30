package ordersmanagement.models;

public class OrderEntry {
    private Product product;
    private int quantity;
    private double subTotal;

    public OrderEntry() {
    }

    public OrderEntry(Product product, int quantity, double subTotal) {
        this.product = product;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
