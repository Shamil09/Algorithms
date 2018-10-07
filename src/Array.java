/*
 Р”РѕРїРёСЃР°С‚СЊ РјРµС‚РѕРґС‹ СѓРґР°Р»РµРЅРёСЏ РІ РєР»Р°СЃСЃРµ РјР°СЃСЃРёРІР°
 РЈР»СѓС‡С€РёС‚СЊ РїСѓР·С‹СЂСЊРєРѕРІСѓСЋ СЃРѕСЂС‚РёСЂРѕРІРєСѓ
 РџРѕРґСЃС‡РёС‚Р°С‚СЊ РєРѕР»РёС‡РµСЃС‚РІРѕ РѕРїРµСЂР°С†РёР№ РІ СЃРѕСЂС‚РёСЂРѕРІРєР°С… Рё СЃСЂР°РІРЅРёС‚СЊ СЃ РёС… Рћ-Р±РѕР»СЊС€РѕРµ
 * Р РµР°Р»РёР·РѕРІР°С‚СЊ СЃРѕСЂС‚РёСЂРѕРІРєСѓ РїРѕРґСЃС‡С‘С‚РѕРј
 * */

public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = 0;
        this.arr = new int[size];
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int length() {
        return size;
    }

    public int get(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
        isSorted = false;
    }

    public void append(int value) {
        if (size >= arr.length) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
        isSorted = false;
    }

    /**
     * Deletes the last value in array
     */
    boolean delete() {
        if (size == 0) return false;
        size--;
        return true;
    }

    boolean delete(int index) { // by index
        if (size == 0 || index>size-1 || index<0) return false;
        System.arraycopy(arr, index+1, arr, index, arr.length-index-1);
        size--;
        return true;
    }
    /*
    Тут можно было бы использовать итераторы или просто цикл While
    ну как вы сказали на первом занятий fori работает быстрей
     */
//    boolean deleteAll(int value) { // by value
//        int n=arr.length;
//        for (int i = 0; i <n; i++) {
//            if (arr[i]==value) {
//                delete(i);
//                n=arr.length;
//            }
//        }
//        return true;
//    }
    /*
    deleteAll(int value, true)- удаляет все вхождения элемента value, иначе первое вхождение
     */
    boolean deleteAll(int value, boolean all) { // by value
        int i = 0;
        if (all) {
            all=false;
            for (i = 0; i < size; i++)
                if (arr[i] == value) {
                    delete(i);
                    all = true;
                }

        } else
            while (!all && i < size) {
                if (arr[i] == value) {
                    delete(i);
                    all = true;
                }
                i++;
            }
        return all;
    }

    void deleteAll() { // clear array
        size=0;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == size - 1)
                return b.append("]").toString();
            b.append(", ");
        }
    }

    /**
     * Search
     */
    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("Try the 'find' method");
        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            // n >> k == n / 2 ^ k
            m = (l + r) >> 1; // 8 = 00001000 >> 1 = 00000100 = 4
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    /**
     * Sort
     */
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
        isSorted = true;
    }

    public void sortSelect() {
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++) {
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            }
            swap(flag, cMin);
        }
        isSorted = true;
    }

    public void sortInsert() {
        int in;
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
    }

}
