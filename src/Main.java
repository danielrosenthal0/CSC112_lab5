import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;

public class Main {
    public static int evaluatePostfix(String expr) {
        int result = 0;
        int num = 0;
        int num2 = 0;
        Stack<Integer> operands = new Stack<Integer>();
        while (expr.length() > 0) {
           String c;

           if (expr.contains(" ")) {
               c = expr.substring(0, expr.indexOf(" "));
           }
           else {
               c = expr;
               expr = "";
           }
            //System.out.println(c);
            if (c.equals("+")) {
                int operand1 = operands.pop();
                int operand2 = operands.pop();
                //System.out.println("test");
                result = operand1 + operand2;
                //System.out.println(result);
                operands.push(result);
                expr = expr.substring(expr.indexOf(" ") + 1);
            } else if (c.equals( "*")) {
                for(int n: operands){
                    //System.out.println("list " + n);
                }
                int operand1 = operands.pop();
                int operand2 = operands.pop();
                result = operand1 * operand2;
                operands.push(result);
                expr = expr.substring(expr.indexOf(" ") + 1);
            }
            else{
               num = Integer.parseInt(c);
               operands.push(num);
            //System.out.println(num);
               expr = expr.substring(expr.indexOf(" ") + 1);
                //System.out.println(expr);
                }
//               num2 = Integer.parseInt(c);
//            System.out.println(num2);
//               operands.push(num2);
//            System.out.println("test1");






            //System.out.println(num);


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
            System.out.println("result " + evaluatePostfix(lines)) ;

        }
        reader.close();
    }
}
