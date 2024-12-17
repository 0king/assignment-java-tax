import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator();
        calculator.addToExemptions(new ItemType[]{ItemType.BOOKS, ItemType.FOOD, ItemType.MEDICINE});

        InputParser parser = new InputParser(calculator);
        try {
            List<Cart> carts = parser.parse(System.in);
            IO.print(carts);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}