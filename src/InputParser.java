public class InputParser {
    private final String input;

    InputParser(String s) {
        input = s;
    }

    int getQuantity() {
        return Integer.parseInt(input.substring(0,1));
    }

    boolean getIsImported() {
        return input.contains("imported");
    }

    String getName() {
        int idx = getIndexOfAt();
        String nm;
        if (getIsImported()) nm = input.substring(11, idx);
        else nm = input.substring(2, idx);
        return  nm;
    }

    int getPrice() {
        int idx = getIndexOfAt();
        float f = Float.parseFloat(input.substring(idx + 4));
        return (int) (f * 100);
    }

    ItemType getType() {
        String nm = getName();
        ItemType ty;
        if (nm.contains("book")) ty = ItemType.BOOKS;
        else if (nm.contains("chocolate")) ty = ItemType.FOOD;
        else if (nm.contains("headache")) ty = ItemType.MEDICINE;
        else ty = ItemType.OTHERS;
        return ty;
    }

    private int getIndexOfAt(){
        return input.indexOf(" at ");
    }

}
