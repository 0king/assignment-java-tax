import java.util.List;

public class IO {

    public static void print(CartItem item) {
        System.out.print(item.getQuantity() + " ");
        if (item.isImported())
            System.out.print("imported ");
        System.out.print(item.getName() + ": ");
        System.out.printf("%.2f", item.getFinalPrice() / 100F);
    }

    public static void print(Cart cart) {
        for (CartItem item: cart.getItems()) {
            print(item);
            System.out.println();
        }
        System.out.print("Sales tax: ");
        System.out.printf("%.2f", cart.calculateTotalTax() / 100);
        System.out.println();
        System.out.print("Total: ");
        System.out.printf("%.2f", cart.calculateTotal() / 100);
        System.out.println();
    }

    public static void print(List<Cart> carts) {
        for (Cart c: carts) {
            System.out.println("\nOutput " + c.getId() + ":");
            print(c);
        }
    }

    public static void print(String s){
        System.out.print(s);
    }
    public static void println(String s){
        System.out.println(s);
    }

}
