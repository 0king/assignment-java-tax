import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    private TaxCalculator calculator;

    public Cart(TaxCalculator calc) {
        this.items = new ArrayList<>();
        calculator = calc;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        for (CartItem e:items)
            addItem(e);
    }

    public void addItem(CartItem item) {
        calculator.calculateTax(item);
        items.add(item);
    }

    public float calculateTotalTax() {
        return items.stream()
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

    void printCart() {
        for (CartItem item: items) {
            item.print();
            System.out.println();
        }
        System.out.print("Sales tax: ");
        System.out.printf("%.2f", calculateTotalTax() / 100);
        System.out.println();
        System.out.print("Total: ");
        System.out.printf("%.2f", calculateTotal() / 100);
        System.out.println();
    }
}
