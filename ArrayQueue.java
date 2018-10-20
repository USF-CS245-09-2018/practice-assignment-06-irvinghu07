import java.util.Arrays;

/**
 * A class that implements a Queue ADT using a circular array
 * The code is modified from Prof. Galles's code.
 */
public class ArrayQueue implements Queue {

    static final int defaultsize = 10;

    private Object data[]; // the array that will store the queue
    private int head;
    private int tail;
    private int size; // the maximum # of elements it can hold

    ArrayQueue(int maxsize) {
        data = new Object[maxsize];
        Arrays.fill(data, Integer.valueOf(0));
        head = 0;
        tail = 0;
        size = maxsize;
    }

    ArrayQueue() {
        data = new Object[defaultsize];
        head = 0;
        tail = 0;
        size = defaultsize;
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
            tail = data.length-1;
        } else {

            for (; i < size; i++)
                newdata[i] = data[i];

        }
        data = newdata;
        size = size * 2;
    }

    /**
     * Add an element to the end of the queue, if it's not full
     */
    public void enqueue(Object elem) {
        // Before adding, check if the queue is full
        if ((tail + 1) % size == head) {
            growQueue();
        }
        data[tail] = elem;
        tail = (tail + 1) % size;
    }

    public Object dequeue() {
        Object retval;

        if (head == tail)
            return null;
        retval = data[head];
        head = (head + 1) % size;
        return retval;
    }

    public boolean empty() {
        return head == tail;
    }

    public String toString() {
        String result = "[";
        int tmpHead = head;
        if (tmpHead != tail) {
            result = result + data[tmpHead];
            tmpHead = (tmpHead + 1) % size;
            while (tmpHead != tail) {
                result = result + "," + data[tmpHead];
                tmpHead = (tmpHead + 1) % size;
            }
        }
        result = result + "]";
        return result;
    }

}