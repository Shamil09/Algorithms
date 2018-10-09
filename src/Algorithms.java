import java.util.Random;

public class Algorithms {
/*
    опыты с рекурсией
 */
    private static int[] ar={1,2,3,4,5};

    private static int sum(int l){
        //int s=0;
        if (l==0) return ar[0];
        return sum(l-1)+ar[l];
    }
    private static int sum(int[] m){
        int l=m.length;
        int[] n=new int[l];
        int s=0;
        System.arraycopy(m,0,n,0,l);
        s=s+n[l-1];
        if (l==1) return n[0];
        n=new int[--l];
        System.arraycopy(m,0,n,0,l);
        return sum(n);
    }
    //************
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

            System.out.println("R_len"+sum(4));
            System.out.println("R_mas"+sum(ar));
        }
    }
}
