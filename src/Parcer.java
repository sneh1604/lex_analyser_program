import java.util.Scanner;

class RecursiveDescentParser {
    private String input;
    private int pos = 0;

    public RecursiveDescentParser(String input) {
        this.input = input;
    }

    private void error() {
        System.out.println("Error: Unexpected token '" + input.charAt(pos) + "' at position " + pos);
        System.exit(1);
    }

    private void match(char expected) {
        if (pos < input.length() && input.charAt(pos) == expected) {
            pos++;
        } else {
            error();
        }
    }

    private void F() {
        if (pos < input.length() && Character.isLetter(input.charAt(pos))) { // F -> id
            System.out.println("F -> id");
            pos++;
        } else {
            error();
        }
    }

    private void T() {
        System.out.print("T -> ");
        F();
        if (pos < input.length() && input.charAt(pos) == '*') { // T -> F * T
            System.out.println(" * T");
            match('*');
            T();
        } else {
            System.out.println();
        }
    }

    private void E() {
        System.out.print("E -> ");
        T();
        if (pos < input.length() && input.charAt(pos) == '+') { // E -> T + E
            System.out.println(" + E");
            match('+');
            E();
        } else {
            System.out.println();
        }
    }

    public void parse() {
        System.out.println("Parsing steps:");
        E();
        if (pos == input.length()) {
            System.out.println("Parsing successful.");
        } else {
            error();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the expression: ");
        String input = scanner.next();
        scanner.close();
        
        RecursiveDescentParser parser = new RecursiveDescentParser(input);
        parser.parse();
    }
}
