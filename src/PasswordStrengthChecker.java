import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {
    
    // Regular expressions for password validation
    private static final String UPPER_CASE = ".*[A-Z].*";
    private static final String LOWER_CASE = ".*[a-z].*";
    private static final String DIGIT = ".*[0-9].*";
    private static final String SPECIAL_CHAR = ".*[!@#$%^&*()\\-_=+{};:,<>.].*";
    
    public static String evaluatePasswordStrength(String password) {
        int strengthCount = 0;
        
        if (password.length() >= 8) strengthCount++;
        if (Pattern.matches(UPPER_CASE, password)) strengthCount++;
        if (Pattern.matches(LOWER_CASE, password)) strengthCount++;
        if (Pattern.matches(DIGIT, password)) strengthCount++;
        if (Pattern.matches(SPECIAL_CHAR, password)) strengthCount++;
        
        // Classify password strength
        if (strengthCount < 3) {
            return "Weak";
        } else if (strengthCount == 3 || strengthCount == 4) {
            return "Moderate";
        } else {
            return "Strong";
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        
        String strength = evaluatePasswordStrength(password);
        System.out.println("Password Strength: " + strength);
        
        scanner.close();
    }
}
