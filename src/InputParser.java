import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputParser {

    private final TaxCalculator calculator;

    InputParser(TaxCalculator calc) {
        calculator = calc;
    }

    //@Nullable
    List<Cart> parse(File file) throws IOException {
        List<Cart> carts = null;
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()){
            String in = sc.nextLine();
            if(in.startsWith("Input")){
                if(carts == null) {
                   carts = new ArrayList<>();
                }
                Cart cart = new Cart();
                carts.add(cart);
                while (sc.hasNextLine()){
                    String s = sc.nextLine();
                    if (s.isEmpty()) break;
                    cart.addItem(StringParser.parse(s, calculator));
                }
            }
        }
        return carts;
    }

    private static class StringParser {

        static CartItem parse(String s, TaxCalculator calc) {
            CartItem item = new CartItem();
            item.setQuantity(getQuantity(s));
            item.setImported(isImported(s));
            item.setName(getName(s));
            item.setType(getType(s));
            item.setPrice(getPrice(s));
            item.setTax(calc.calculateTax(item));
            return item;
        }

        static int getQuantity(String s) {
            return Integer.parseInt(s.substring(0,1));
        }

        static boolean isImported(String s) {
            return s.contains("imported");
        }

        private static String getName(String s) {
            int idx = getIndexOfAt(s);
            String nm;
            if (isImported(s))
                nm = s.substring(11, idx);
            else nm = s.substring(2, idx);
            return  nm;
        }

        static int getPrice(String s) {
            int idx = getIndexOfAt(s);
            float f = Float.parseFloat(s.substring(idx + 4));
            return (int) (f * 100);
        }

        static ItemType getType(String s) {
            String nm = getName(s);
            ItemType ty;
            if (nm.contains("book")) ty = ItemType.BOOKS;
            else if (nm.contains("chocolate")) ty = ItemType.FOOD;
            else if (nm.contains("headache")) ty = ItemType.MEDICINE;
            else ty = ItemType.OTHERS;
            return ty;
        }

        private static int getIndexOfAt(String s){
            return s.indexOf(" at ");
        }

    }

}
