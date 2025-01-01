import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCountLexer {
    public static void main(String[] args) {
        String inputFilePath = "wc.txt";

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (Scanner scanner = new Scanner(new File(inputFilePath))) {
            while (scanner.hasNextLine()) {
                // Read a line from the file
                String line = scanner.nextLine();
                lineCount++; // Increment line count

                // Count words in the line
                String[] words = line.split("\\s+");
                wordCount += words.length;

                // Count characters in the line
                charCount += line.length();
            }

            // Print the results
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
