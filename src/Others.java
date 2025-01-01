import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Others {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
    try {
      File myObj = new File("others");
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
                System.out.println("Word : " + lexem);
            } else if(lexem.matches("^-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?$")){
                System.out.println("Number : " + lexem);
            }
           
            
        }
      }
      myReader.close();
      myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        // read a line from program
        String data = myReader.nextLine();

        for (int i=0;i<data.length();i++) {
          // Lexem it is an identifier
          ///System.out.println("Matching " + data.substring(i,i+1));
            if(data.substring(i,i+1).matches("[#@{}\\(\\)=;$%]")){
                System.out.println(data.substring(i,i+1) + " is a special symbol");
            } 
        }
      }
     
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}