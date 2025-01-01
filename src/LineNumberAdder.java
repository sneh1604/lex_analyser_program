import java.io.*;
import java.util.Scanner;

public class LineNumberAdder {
    public static void main(String[] args) {

        String inputFilePath = "input.txt";

        String outputFilePath = "output.txt";

        try (
            Scanner scanner = new Scanner(new File(inputFilePath));
            PrintWriter writer = new PrintWriter(new File(outputFilePath))
        ) {
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.println(lineNumber + " " + line);
                lineNumber++;
            }
            System.out.println("Line numbers added and output saved to: " + outputFilePath);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
