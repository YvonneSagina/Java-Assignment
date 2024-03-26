public class MenuItem {
    private String product;
    private double price;
    private int quantity;

    public MenuItem(String product, double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public MenuItem() {
    }

    public String getProduct() {
        return this.product;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
