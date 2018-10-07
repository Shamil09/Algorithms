public class Queue {
    private int[] queue;
    private int head;
    private int tail;
    private int size;
    private int items;

    public Queue(int size) {
        this.size = size;
        this.queue = new int[size];
        head = 0;
        tail = -1;
        items = 0;
    }
    public boolean isEmpty() {
        return items == 0;
    }
    public boolean isFull() {
        return items == size;
    }
    public int length() {
        return items;
    }
    public void insert(int i) {
        if (isFull()) {
            size *= 2;
            int[] temp = new int[size];
            if (tail >= head) {
                System.arraycopy(queue, 0, temp, 0, queue.length);
            } else {
                System.arraycopy(queue, 0, temp, 0, tail - 1);
                System.arraycopy(queue, head, temp,
                        size - (queue.length - head),
                        queue.length - head - 1);
                head = size - head - 1;
            }
            queue = temp;
        }
        if (tail == size - 1)
            tail = -1;
        queue[++tail] = i;
        items++;
    }
    public int remove() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        int temp = queue[head++];
        head %= size;
        items--;
        return temp;
    }
    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue[head];
    }

}
// t[h........]
//  [h||||t............]
//  [..h||t............]
//  [|t...h|||]