import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentExtractor {
    public static void main(String[] args) {
        try {
            File myObj = new File("comment.c");
            Scanner myReader = new Scanner(myObj);
            String singleLineCommentRegex = "//.*";
            String multiLineCommentRegex = "/\\*.*?\\*/";

            Pattern commentPattern = Pattern.compile(
                singleLineCommentRegex + "|" + multiLineCommentRegex,
                Pattern.DOTALL
            );

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Matcher matcher = commentPattern.matcher(data);
                while (matcher.find()) {
                    System.out.println("Comment: " + matcher.group());
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
