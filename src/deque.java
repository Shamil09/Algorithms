import java.lang.reflect.Array;
import java.util.LinkedList;
class Deque<T> {
    private T[] dekaArr;
    private int head;
    private int size;
    private int items;

    public Deque(Class<T[]> c, int size) {
        this.dekaArr = c.cast(Array.newInstance(c.getComponentType(), size));;
        this.size=size;
        head =-1;
        items=0;
    }

    boolean isFull() {
        return head == size-1;
    }
    public int length() {
        return head+1;
    }
    public boolean isEmpty() {
        return head == -1;
    }

    void insertLeft(T value){

    }
    boolean insertRight(T value){
        if (isFull())
            return false;
        dekaArr[++head] = value;
        return true;
    }
//    T removeLeft(){
//        if (count()==0) return null;
//
//    }
    T removeRight(){
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return dekaArr[head--];
    }

//    T peekLeft(){
//        return arr.getFirst();
//    }
    T peekRight(){
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return dekaArr[head];
    }
}
