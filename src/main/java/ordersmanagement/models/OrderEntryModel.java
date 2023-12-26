package ordersmanagement.models;

public class OrderEntryModel {
    private ProductModel product;
    private int quantity;
    private double subTotal;

    public OrderEntryModel() {
    }

    public OrderEntryModel(ProductModel product, int quantity, double subTotal) {
        this.product = product;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
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
