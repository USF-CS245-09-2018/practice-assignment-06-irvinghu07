import java.util.Arrays;

public class ArrayQueue implements Queue {

    static final int DEFAULT_SIZE = 10;

    private Object data[];
    private int head;
    private int tail;
    private int size;

    public ArrayQueue(int maxsize) {
        data = new Object[maxsize];
        Arrays.fill(data, Integer.valueOf(0));
        head = 0;
        tail = 0;
        size = maxsize;
    }

    public ArrayQueue() {
        data = new Object[DEFAULT_SIZE];
        head = 0;
        tail = 0;
        size = DEFAULT_SIZE;
    }

    protected void growQueue() {
        int i = 0;
        Object newdata[];
        newdata = new Object[size * 2];
        if (head > tail) {
            for (int j = head; j < data.length; j++) {
                newdata[i++] = data[j];
            }
            for (int j = 0; j < tail; j++) {
                newdata[i++] = data[j];
            }
            head = 0;
            tail = data.length - 1;
        } else {

            for (; i < size; i++)
                newdata[i] = data[i];

        }
        data = newdata;
        size = size * 2;
    }

    @Override
    public void enqueue(Object elem) {
        // Before adding, check if the queue is full
        if ((tail + 1) % size == head) {
            growQueue();
        }
        data[tail] = elem;
        tail = (tail + 1) % size;
    }

    @Override
    public Object dequeue() {
        Object ret;

        if (head == tail)
            return null;
        ret = data[head];
        head = (head + 1) % size;
        return ret;
    }

    @Override
    public boolean empty() {
        return head == tail;
    }

}