import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.regex.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class EmailScraper {
    private static final String EMAIL_REGEX = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static Set<String> extractEmails(String text) {
        Set<String> emails = new HashSet<>();
        Matcher matcher = EMAIL_PATTERN.matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static String fetchFromURL(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        return doc.text();
    }

    public static String readFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public static void saveEmailsToFile(Set<String> emails, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String email : emails) {
                writer.write(email);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> allEmails = new HashSet<>();

        try {
            System.out.print("Enter a URL or file path: ");
            String input = scanner.nextLine();
            String content;

            if (input.startsWith("http")) {
                content = fetchFromURL(input);
            } else if (new File(input).exists()) {
                content = readFromFile(input);
            } else {
                System.out.println("Invalid input! Please enter a valid URL or existing file path.");
                return;
            }
            allEmails.addAll(extractEmails(content));
            if (allEmails.isEmpty()) {
                System.out.println("No email addresses found.");
            } else {
                System.out.println("Extracted email addresses:");
                allEmails.forEach(System.out::println);
            }

            System.out.print("Do you want to save emails to a file? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.print("Enter filename to save: ");
                String filename = scanner.nextLine();
                saveEmailsToFile(allEmails, filename);
                System.out.println("Emails saved to " + filename);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
