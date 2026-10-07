import java.util.Scanner;
import java.util.Stack;

public class StudentList {

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

    static String infixToPostfix(String infix) {

        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {

            char ch = infix.charAt(i);

            // Operand
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }

            // Opening bracket
            else if (ch == '(') {
                stack.push(ch);
            }

            // Closing bracket
            else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }

                if (!stack.isEmpty())
                    stack.pop();
            }

            // Operator
            else {
                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(stack.peek()) >= precedence(ch)) {

                    postfix.append(stack.pop());
                }

                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
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