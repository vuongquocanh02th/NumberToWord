import java.util.Scanner;

public class NumberToWord {

    // Các từ đại diện cho các đơn vị và hàng chục
    private static final String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    // Phương thức đọc số có một chữ số
    public static String readSingleDigit(int number) {
        switch (number) {
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "out of ability";
        }
    }

    // Phương thức đọc các số có hai chữ số nhỏ hơn 20
    public static String readTensUnder20(int number) {
        switch (number) {
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            default: return "out of ability";
        }
    }

    // Phương thức đọc các số có hai chữ số lớn hơn hoặc bằng 20
    public static String readTensAndOnes(int tens, int ones) {
        String result = "";
        switch (tens) {
            case 2: result = "twenty"; break;
            case 3: result = "thirty"; break;
            case 4: result = "forty"; break;
            case 5: result = "fifty"; break;
            case 6: result = "sixty"; break;
            case 7: result = "seventy"; break;
            case 8: result = "eighty"; break;
            case 9: result = "ninety"; break;
            default: result = ""; break;
        }
        if (ones != 0) {
            result += " " + units[ones];
        }
        return result.trim();
    }

    // Phương thức đọc số có ba chữ số
    public static String readHundreds(int number) {
        int hundreds = number / 100;
        int remainder = number % 100;

        String result = units[hundreds] + " hundred";
        if (remainder != 0) {
            result += " and " + readNumber(remainder);
        }
        return result.trim();
    }

    // Phương thức đọc số chung
    public static String readNumber(int number) {
        if (number < 10) {
            return readSingleDigit(number);
        } else if (number < 20) {
            return readTensUnder20(number);
        } else if (number < 100) {
            int tens = number / 10;
            int ones = number % 10;
            return readTensAndOnes(tens, ones);
        } else if (number < 1000) {
            return readHundreds(number);
        } else {
            return "out of ability";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (0 to 999): ");
        int number = scanner.nextInt();

        String result = readNumber(number);
        System.out.println("The number in words is: " + result);
    }
}
