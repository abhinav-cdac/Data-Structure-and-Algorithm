
import java.util.Stack;

public class ExpressionEvaluation {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;
                    if (i < expression.length())
                        c = expression.charAt(i);
                    else
                        break;
                }
                i--;
                stack.push(num);
            } else if (c == ' ') {
                // Ignore spaces
                continue;
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                int num = 0;
                int decimalPlace = 1;
                while (i >= 0 && Character.isDigit(expression.charAt(i))) {
                    num = (expression.charAt(i) - '0') * decimalPlace + num;
                    decimalPlace *= 10;
                    i--;
                }
                i++;
                stack.push(num);
            } else if (c == ' ') {
                // Ignore spaces
                continue;
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(val1 + val2);
                        break;
                    case '-':
                        stack.push(val1 - val2);
                        break;
                    case '*':
                        stack.push(val1 * val2);
                        break;
                    case '/':
                        stack.push(val1 / val2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "100 200 + 2 / 5 * 7 +";
        System.out.println("Postfix Evaluation: " + evaluatePostfix(postfix));

        String prefix = "+ 9 * 2 3";
        System.out.println("Prefix Evaluation: " + evaluatePrefix(prefix));

        // Testing multi-digit prefix
        String prefixMultiDigit = "+ * 100 200 50";
        System.out.println("Prefix Evaluation (multi-digit): " + evaluatePrefix(prefixMultiDigit));
    }
}
