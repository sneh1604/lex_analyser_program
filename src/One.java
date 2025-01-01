import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        try {
            File myObj = new File("others");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                // Read a line from the file
                String data = myReader.nextLine();
                // Split the string by spaces to get tokens
                String[] tokens = data.split("[\\s]+");

                // Loop through each token
                for (String token : tokens) {
                    // Check if the token is a word
                    if (isWord(token)) {
                        System.out.println("word: " + token);
                    }
                    // Check if the token is a number
                    else if (isNumber(token)) {
                        System.out.println("number: " + token);
                    }
                    // Check if the token is "other"
                    else if (isOther(token)) {
                        System.out.println("other: " + token);
                    }
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Method to check if a token is a word (only alphabetic characters)
    private static boolean isWord(String token) {
        // A word is composed of only alphabetic characters
        for (int i = 0; i < token.length(); i++) {
            char c = token.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a token is a number
    private static boolean isNumber(String token) {
        // A number can be integer or floating point
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Method to check if a token is "other" (non-alphanumeric symbols)
    private static boolean isOther(String token) {
        // Check if the token contains any special symbols
        for (int i = 0; i < token.length(); i++) {
            char c = token.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
