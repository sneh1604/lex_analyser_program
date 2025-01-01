import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Tokenizer {
    public static void main(String[] args) {
    try {
      File myObj = new File("Demo.c");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        // read a line from program
        String data = myReader.nextLine();
        // seperate lexems from the line
        String lexems[] = data.split("[ \\n\\t,(){}=+\\-;]");
        //System.out.println("Reading a line" + data);
        System.out.println("Lexemes are " + Arrays.toString(lexems));
        // check the token
        for (String lexem : lexems) {
            if(lexem.matches("^[a-zA-Z$_][a-zA-Z$_0-9]{0,9}")){
                System.out.println(lexem + " is an identifier");
            } else if(lexem.matches("^-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?$")){
                System.out.println(lexem + " is a numerical constant");
            }
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
