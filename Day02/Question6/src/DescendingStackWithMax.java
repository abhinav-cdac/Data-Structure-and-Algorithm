
public class DescendingStackWithMax {
    private int[] stack;
    private int top;
    private int max;

    public DescendingStackWithMax(int capacity) {
        stack = new int[capacity];
        top = capacity;
        max = Integer.MIN_VALUE;
    }

    public void push(int value) {
        if (top == 0) {
            System.out.println("Stack is full");
        } else {
            stack[--top] = value;
            if (value > max) {
                max = value;
            }
        }
    }

    public int pop() {
        if (top == stack.length) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int value = stack[top++];
            if (value == max) {
                // Recalculate max since we cannot traverse
                max = Integer.MIN_VALUE;
                for (int i = top; i < stack.length; i++) {
                    if (stack[i] > max) {
                        max = stack[i];
                    }
                }
            }
            return value;
        }
    }

    public int getMax() {
        return max;
    }

    public static void main(String[] args) {
        DescendingStackWithMax stack = new DescendingStackWithMax(5);
        stack.push(10);
        stack.push(50);
        stack.push(30);
        stack.push(20);
        stack.push(40);

        System.out.println("Maximum value in the stack: " + stack.getMax());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Maximum value in the stack: " + stack.getMax());
    }
}
