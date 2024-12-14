public class CartItem {

    private int id;
    private ItemType type;
    private String name; //chocolate bar
    private int quantity;
    private int price; //multiplied by 100
    private boolean isImported;
    private float tax; //calculated tax

    // create object from string - 1 imported box of chocolates at 10.00
    public CartItem(InputParser parser) {
        name = parser.getName();
        type = parser.getType();
        quantity = parser.getQuantity();
        price = parser.getPrice();
        isImported = parser.getIsImported();
    }

    public CartItem(int id) {
        this.id = id;
    }

    public CartItem(int quantity, float price, String name, ItemType type, boolean isImported) {
        this.type = type;
        this.quantity = quantity;
        this.price = (int)(price * 100);
        this.name = name;
        this.isImported = isImported;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = (int) (price * 100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public float getFinalPrice() {
        return price + tax;
    }

    public void print() {
        System.out.print(quantity + " ");
        if (isImported) System.out.print("imported ");
        System.out.print(name + ": ");
        System.out.printf("%.2f", getFinalPrice() / 100F);
    }
}
