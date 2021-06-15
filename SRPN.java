import java.util.*;


public class SRPN {
    private int result = 0;
    private Stack<Integer> stack = new Stack<>();
    SRPNRandom random = new SRPNRandom();

    private IntegerHandling intHand = new IntegerHandling();

    public void processCommand(String s) {
        try {
            if (s.equals("+")) { //Addition
                if (stack.size() > 1) {
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    if (intHand.willAdditionOverflow(n2, n1) == false) { //this tests if the number will exceed Stack Overflow and handle it accordingly.
                        result = n2 + n1;
                        stack.push(result);
                    } else if (intHand.willAdditionOverflow(n2, n1) == true) {
                        stack.push(Integer.MAX_VALUE);
                    }
                } else {
                    System.out.println("Stack underflow.");
                }
            } else if (s.equals("-")) { //Minus
                int n1 = stack.pop();
                int n2 = stack.pop();
                if (intHand.willSubtractionOverflow(n2, n1) == false) {
                    result = n2 - n1;
                    stack.push(result);
                } else if (intHand.willSubtractionOverflow(n2, n1) == true) {
                    stack.push(Integer.MIN_VALUE); // this tests for stack Underflow and deals with it accordingly
                }
            } else if (s.equals("*")) { //multiplication
                try {
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    result = n2 * n1;
                } catch (EmptyStackException e) {
                    System.out.println("Stack Underflow.");
                }
                stack.push(result);

            } else if (s.equals("/")) { //Division
                try {
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    result = n2 / n1;
                } catch (ArithmeticException e) {
                    System.out.println("Divide by 0."); //catches a any divisions with 0
                }
                stack.push(result);
            } else if (s.equals("d")) {
                for (int i = 0; i < stack.size(); ++i) {
                    System.out.println(stack.get(i));// this returns what's on top of the stack
                }
            } else if (s.equals("r")) { //random number generation
                int current_random = random.listSRPNRandom(); //this returns a list of random numbers
                stack.push(current_random);
            } else if (s.contains("#")) { // this stops the comment being added to the stack
                s = s.split("#")[0].trim();
                if (s.isEmpty()) {
                    return;
                }
            } else if (s.equals("=")) { //equal
                if (stack.empty() == false) {
                    System.out.println(stack.peek());
                } else if (stack.empty() == true) {
                    System.out.println("Stack Empty."); // This check if the stack is empty and if true, prints Stack Empty.
                }
            } else {

                int i = Integer.parseInt(s); //this processes the numbers and adds them to the stack.
                stack.push(i);

            }
        } catch (NumberFormatException e) {
            if (s.contains("r")) {
                int length = s.length();
                char[] arr = new char[length];
                for (int i=0; i<length; i++)
                {
                    processCommand(String.valueOf(arr[i]));
                }
            } else {
                    String[] stringParts = s.split("((?<=\\D)|(?=\\D))");
                    for (int i = 0; i < stringParts.length; ++i) {
                        processCommand(stringParts[i]);
                    }
                }
            }
        }
    }










