import java.util.Random;

public class Algorithms {
    public static void main(String[] args) {
//        System.out.println(Math.sqrt(2,5));
//
//        int mas[]={4, 2, 0, -1, -6, 10, 6};
//        System.out.println(Math.min(mas));
//
//        System.out.println(Math.average(mas));

//        Array ar=new Array(4, 2, 0, -1, -6, 10, 6,-1);
//        ar.deleteAll(-1,false);
//        System.out.println(ar);

//        PriorityQueue q = new PriorityQueue(5);
//        q.insert(30);
//        q.insert(50);
//        q.insert(10);
//        q.insert(40);
//        q.insert(20);
//        while( !q.isEmpty() )
//        {
//            int item = q.remove();
//            System.out.print(item + " ");
//        }
//        System.out.println();
//        System.out.println("123456->"+PriorityQueue.shifter("123456"));
        Deque<String> t = new Deque<>(String[].class,10);

        t.insertRight("1");
        t.insertRight("2");
        t.insertRight("3");
        t.insertRight("4");
        t.insertRight("5");

        System.out.println("-----------------");
        System.out.println(t.peekRight());
        while (!t.isEmpty()) {
            System.out.println(t.removeRight());
            System.out.println("L->"+t.length());
        }


    }
}
