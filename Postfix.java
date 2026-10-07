import java.util.Scanner;
import java.util.Stack;

public class Postfix {

    // Function to determine operator precedence
    static int precedence(char ch) {
        if (ch == '^')
            return 3;
        else if (ch == '*' || ch == '/' || ch == '%')
            return 2;
        else if (ch == '+' || ch == '-')
            return 1;
        else
            return 0;
    }

    // Function to convert infix to postfix
    static String infixToPostfix(String infix) {

        Stack<Character> stack = new Stack<>();
        String postfix = "";

        for (int i = 0; i < infix.length(); i++) {

            char ch = infix.charAt(i);

            // If operand, add directly to postfix
            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            }

            // If opening parenthesis
            else if (ch == '(') {
                stack.push(ch);
            }

            // If closing parenthesis
            else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }

                stack.pop(); // Remove '('
            }

            // If operator
            else {
                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(stack.peek()) >= precedence(ch)) {

                    postfix += stack.pop();
                }

                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String infix = sc.nextLine();

        String postfix = infixToPostfix(infix);

        System.out.println("Postfix expression: " + postfix);

        sc.close();
    }
}