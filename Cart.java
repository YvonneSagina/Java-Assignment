import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<MenuItem> items;
    private static final int max_items = 7;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public void addItem(MenuItem item, int quantity) {
        if (item != null && quantity > 0 && items.size() < max_items) {
            boolean itemExists = false;
            for (MenuItem existingItem : items) {
                if (existingItem.getProduct().equals(item.getProduct())) {
                    existingItem.setQuantity(existingItem.getQuantity() + quantity);
                    itemExists = true;
                    break;
                }
            }
            if (!itemExists) {
                items.add(new MenuItem(item.getProduct(), item.getPrice(), quantity));
            }
            System.out.println("Item added to cart: " + item);
        }
    }
}
