import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws IOException {
        TaxCalculator calculator = new TaxCalculator();
        calculator.addToExemptions(new ItemType[]{ItemType.BOOKS, ItemType.FOOD, ItemType.MEDICINE});

        File file = new File("src/assets/input-data.txt");
        Scanner sc = new Scanner(file);
        int counter = 1;

        while (sc.hasNextLine()){
            String in = sc.nextLine();
            if(in.startsWith("Input")){
                Cart cart = new Cart(calculator);
                while (sc.hasNextLine()){
                    String s = sc.nextLine();
                    if (s.isEmpty()) break;
                    cart.addItem(new CartItem(new InputParser(s)));
                }
                System.out.println("\nOutput " + counter++ + ":");
                cart.printCart();
            }
        }

    }
}