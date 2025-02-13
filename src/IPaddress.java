import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class IPaddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an IP address:");
        String ip = scanner.nextLine();
        
        if (isValidIPv4(ip)) {
            System.out.println(ip + " is a valid IPv4 address.");
        } else if (isValidIPv6(ip)) {
            System.out.println(ip + " is a valid IPv6 address.");
        } else {
            System.out.println(ip + " is not a valid IP address.");
        }
        
        scanner.close();
    }

    public static boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidIPv6(String ip) {
        String[] parts = ip.split(":");
        if (parts.length != 8) {
            return false;
        }
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) {
                return false;
            }
            try {
                int num = Integer.parseInt(part, 16);
                if (num < 0 || num > 0xFFFF) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
}