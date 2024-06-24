
public class DescendingStack {
    private int[] stack;
    private int top;

    public DescendingStack(int capacity) {
        stack = new int[capacity];
        top = capacity;
    }

    public void push(int value) {
        if (top == 0) {
            System.out.println("Stack is full");
        } else {
            stack[--top] = value;
        }
    }

    public int pop() {
        if (top == stack.length) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top++];
        }
    }

    public boolean isEmpty() {
        return top == stack.length;
    }

    public static void main(String[] args) {
        DescendingStack stack = new DescendingStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
