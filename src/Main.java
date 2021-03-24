import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;

public class Main {
    //requirement 2
    public static int evaluatePostfix(String expr) {
        //requirement 3
        //intializing integers and operands stack
        int result = 0;
        int num = 0;
        int num2 = 0;
        Stack<Integer> operands = new Stack<Integer>();
        //while loop that works thru length of expr
        while (expr.length() > 0) {
           String c;
            //checks to see if at end of expression or not, sets current string to either operand or operator
           if (expr.contains(" ")) {
               c = expr.substring(0, expr.indexOf(" "));
           }
           //this else happens when at end of expression, basically a default expression
           //sets expression length to 0 and exits while loop
           else {
               c = expr;
               expr = "";
           }
           //checks if c is plus operator first
            //pops the 2 stored integers and does operation
            //pushes result back into stack
            //reduces expr to next character so it can move on
            if (c.equals("+")) {
                int operand1 = operands.pop();
                int operand2 = operands.pop();
                result = operand1 + operand2;
                operands.push(result);
                expr = expr.substring(expr.indexOf(" ") + 1);
            //same thing as plus operator but with multiplication
            } else if (c.equals( "*")) {
                for(int n: operands){
                }
                int operand1 = operands.pop();
                int operand2 = operands.pop();
                result = operand1 * operand2;
                operands.push(result);
                expr = expr.substring(expr.indexOf(" ") + 1);
            }
            //this is where the operands are pushed into stack, also reduces what is left of expr
            else{
               num = Integer.parseInt(c);
               operands.push(num);
               expr = expr.substring(expr.indexOf(" ") + 1);
                }
        }
        //returns final result
        return result;
    }
    //task 2 - queue
    //requirement 2
    public static void Stutter(Queue<Integer> q ) {
        int size = q.size();
        //loop goes thru queue, removes the front and adds two to the back
        //basically a circle, after reaching end of loop everything has been duplicated
        for(int i = 0; i < size; i++) {
            int j = q.remove();
            q.add(j);
            q.add(j);
        }
        System.out.println(q);
    }

    public static void main(String [] args){
        //task 1 - stack
        //requirement 1 - reading expressions file
        FileInputStream fis = null;
        //try and catch for file not found, initializes fis
        try {
            fis = new FileInputStream("src/Postfixexperssions");
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
            System.exit(1);
        }
        Scanner reader = new Scanner(fis);
        while (reader.hasNextLine()) {

            String lines = reader.nextLine();
            //print line for reference
            System.out.println(lines);
            //send to evaluate
            System.out.println("result " + evaluatePostfix(lines)) ;

        }
        reader.close();

        //making queue for task 2
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(3);
        q.add(9);
        q.add(55);
        q.add(10);
        q.add(434523543);
        Stutter(q);
    }
}
