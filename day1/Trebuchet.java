import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Trebuchet {

    public static void main(String[] args) {
        Trebuchet trebuchet = new Trebuchet();
        System.out.println(trebuchet.sumValues("day1/data/trebuchet"));
    }

    public int sum;
    HashMap<String, String> strNums;

    public Trebuchet() {
        sum = 0;
        strNums = new HashMap<>();
        strNums.put("one", "1");
        strNums.put("two", "2");
        strNums.put("three", "3");
        strNums.put("four", "4");
        strNums.put("five", "5");
        strNums.put("six", "6");
        strNums.put("seven", "7");
        strNums.put("eight", "8");
        strNums.put("nine", "9");
    }

    private static ArrayList<String> readFile(String filename) {
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public int sumValues(String filename) {

        ArrayList<String> lines = readFile(filename);

        for (String line : lines) {
            sum += parseValue(line);
        }
        return sum;
    }

    public int parseValue(String line) {

        ArrayList<String> nums = new ArrayList<>();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            for (String num : strNums.keySet()) {
                if ((line.substring(i)).startsWith(num)) {
                    nums.add(strNums.get(num));
                } else if ((c >= '0') && (c <= '9')) {
                    nums.add(String.valueOf(c));
                }
            }
        }
        return (combineNumbers(nums.getFirst(), nums.getLast()));
    }

    public int combineNumbers(String numOne, String numTwo) {
        return Integer.parseInt((numOne + numTwo));
    }

}