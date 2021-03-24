import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;

public class Main {
    public static int evaluatePostfix(String expr) {
        int result = 0;
        Stack<Integer> expressions = new Stack<Integer>();
        for (int i = 0; i < expr.length(); i++) {
           String c;
           c = expr.substring(0,expr.indexOf(" "));
           System.out.println(Integer.parseInt(c));


//           if (Character.isDigit(c)) {
//
//           }
           //c = expr.indexOf(" ");
//            System.out.println(expr.indexOf(" "));
//            if (Character.isDigit(c)) {
//                Integer.parseInt(c);
//                expressions.push(c);
//            }
        }

        return result;
    }

    public static void main(String [] args){

        //requirement 1 - reading expressions file
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/Postfixexperssions");
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
            System.exit(1);
        }
        Scanner reader = new Scanner(fis);
        while (reader.hasNextLine()) {

            String lines = reader.nextLine();
            //test
            System.out.println(lines);
            //send to evaluate
            evaluatePostfix(lines);

        }
        reader.close();
    }
}
