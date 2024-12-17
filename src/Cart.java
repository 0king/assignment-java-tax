import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    private int id;

    public Cart(int id) {
        this.id = id;
        this.items = new ArrayList<>();
    }

    int getId() { return id; }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        for (CartItem e:items)
            addItem(e);
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    public float calculateTotalTax() {
        return items
                .stream()
                .map(CartItem::getTax)
                .reduce(0F, Float::sum);
    }

    public int calculateTotalPrice() {
        return items
                .stream()
                .map(e -> e.getPrice() * e.getQuantity())
                .reduce(0, Integer::sum);
    }

    public float calculateTotal() {
        return calculateTotalPrice() + calculateTotalTax();
    }

}
