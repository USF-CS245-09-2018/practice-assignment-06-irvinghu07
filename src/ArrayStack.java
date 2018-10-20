public class ArrayStack implements Stack {
    public static final int DEFAULT_SIZE = 10;

    private Object data[];

    private int top;

    private int size;

    public ArrayStack() {
        data = new Object[DEFAULT_SIZE];
        top = 0;
        size = DEFAULT_SIZE;
    }

    public ArrayStack(int initSize) {
        data = new Object[initSize];
        top = 0;
        size = initSize;
    }

    @Override
    public boolean empty() {
        return top == 0;
    }

    @Override
    public void push(Object elem) {
        if (top == size) {
            growStack();
        }
        data[top] = elem;
        top++;
    }

    @Override
    public Object pop() {

        if (top > 0) {
            return data[--top];
        }
        return null;
    }

    @Override
    public Object peek() {
        return data[top - 1];
    }

    private void growStack() {
        int i;
        Object newdata[];
        newdata = new Object[size * 2];
        for (i = 0; i < size; i++) {
            newdata[i] = data[i];
        }
        data = newdata;
        size = size * 2;
    }
}