

public class RegExDemo{
    public static void main(String[] args) {
        // How to match a group of charecter with String
        System.out.println("true".matches("true"));
        // // returns true if the string matches exactly "true" or "True"
        System.out.println("True".matches("[tT]rue"));
        // returns true if the string matches exactly "true" or "True" or "yes" or "Yes"
        System.out.println("yes".matches("[tT]rue|[yY]es"));
        // returns true if the string contains of three lower case letters
        System.out.println("yes".matches("[a-z]{3}"));
        // returns true if the string contains of three upper case letters
        System.out.println("YES".matches("[A-Z]{3}"));
        // returns true if the string contains of three either lower case or upper case letters
        System.out.println("yes".matches("[a-zA-Z]{3}"));
        // returns true if the string contains valid exactly 10 digits no.
        System.out.println("9876543210".matches("[0-9]{10}"));
        // returns true if the string contains valid zero or n digits no.
        System.out.println("".matches("[0-9]*"));
        // returns true if the string contains valid one or n digits no.
        System.out.println("1".matches("[0-9]+"));
        // returns true if the string contains valid zero or one digits no.
        System.out.println("".matches("[0-9]?"));
        // returns true if the string contains valid java identifier
        System.out.println("abc123_$".matches("[a-zA-Z$_][a-zA-Z$_0-9]{0,9}"));
        // returns true if the string begins with 0, 1, 2
        System.out.println("166".matches("[012][0-9]+"));
        // returns true if the  number less than 300
        System.out.println("299".matches("[12]?[0-9]{1,2}"));
        // returns true if the string contains a number less than 300
        System.out.println("this is valid 299".matches(".*[12]?[0-9]{1,2}.*"));
        // [0-9] can be represented as [d]
        System.out.println("this is valid 299".matches(".*[12]?[\\d]{1,2}.*"));
        // returns true if the  number less than 256
        System.out.println("255".matches("[\\d]{1,2}|1[\\d]{2}|2[0-4][\\d]|25[0-5]"));
    }
}