import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

public class Algorithms {
    private static int[] arr = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
//        System.out.println(Math.sqrt(2,5));
//
//        int mas[]={4, 2, 0, -1, -6, 10, 6};
//        System.out.println(Math.min(mas));
//
//        System.out.println(Math.average(mas));

//        Array ar=new Array(4, 2, 0, -1, -6, 10, 6,-1);
//        ar.sortBubble();
//        System.out.println(ar);
        //System.out.println(countArrIndex(arr));
        System.out.println(Arrays.toString(quicksort(new int[]{1,24,25,365,78,96,4,4,8,47,5,54,8,0,5,55,444,655,65,2,55,5})));

    }

    static int sum(int[] m) {
        if (m.length == 0) throw new ArrayIndexOutOfBoundsException("Пустой массив ¯\\_(ツ)_/¯");
        if (m.length == 1) return m[0];
        return m[m.length - 1] + sum(Arrays.copyOf(m, m.length - 1));
    }

    static int countArrIndex(int[] m) {
        if (m.length == 0) throw new ArrayIndexOutOfBoundsException("Пустой массив ¯\\_(ツ)_/¯");
        if (m.length == 1) return 1;
        return 1 + countArrIndex(Arrays.copyOf(m, m.length - 1));
    }

    //    static int maxElArr(int[] m){
//        if (m.length==0) throw new ArrayIndexOutOfBoundsException("Пустой массив ¯\\_(ツ)_/¯");
//        if (m.length==1) return m[0];
//        int max;
//        if(max<m[m.length-1])
//        return m[m.length-1]>maxElArr(Arrays.copyOf(m,m.length-1))
//                //1+countArrIndex(Arrays.copyOf(m,m.length-1));
//    }

    static int[] unionArr(int[]... m) {
        int l=0;
        for (int i = 0; i <m.length ; i++)
            l+=m[i].length;
        int[] ar=new int[l];
        l=0;
        for (int i = 0; i <m.length ; i++) {
            System.arraycopy(m[i], 0, ar, l, m[i].length);
            l += m[i].length;
        }
        return ar;
    }

    static int[] quicksort(int[] m) {
        if (m.length < 2) return m;
        int m1[] = {}, m2[] = {};
        int suport[] = {m[0]};
        for (int i = 1; i < m.length; i++)
            if (suport[0] >= m[i]) {
                m1 = Arrays.copyOf(m1, m1.length + 1);
                m1[m1.length - 1] = m[i];
            } else {
                m2 = Arrays.copyOf(m2, m2.length + 1);
                m2[m2.length - 1] = m[i];
            }
        return unionArr(quicksort(m1), suport, quicksort(m2));
    }
}

