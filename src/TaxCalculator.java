import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaxCalculator {
    public static final float SALES_TAX_RATE = 10.0F;
    public static final float IMPORT_TAX_RATE = 5.0F;

    //exemptions list
    private final Set<ItemType> exemptions = new HashSet<>();

    public void addToExemptions(ItemType type) {
        exemptions.add(type);
    }

    public void addToExemptions(ItemType[] typeArr) {
        for (ItemType type : typeArr) {
            addToExemptions(type);
        }
    }

    public void removeFromExemptions(ItemType type) {
        exemptions.remove(type);
    }

    // total tax
    public void calculateTax(CartItem item) {
        float imported = 0;
        if (item.isImported())
            imported = IMPORT_TAX_RATE * item.getPrice() / 100F;
        float basic = 0;
        if (!exemptions.contains(item.getType()))
            basic = SALES_TAX_RATE * item.getPrice() / 100F;

        // set it
        item.setTax(basic + imported);

        //return basic + imported;
    }

}
