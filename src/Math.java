

class Math {
    /**
     * @Shamil sqrt
     * 1.1. Возведение в степень используя чётность степени
     * Бинарное (двоичное) так же четное возведение в степень — это приём,
     * позволяющий возводить любое число в n-ую степень за O(log n) операций
     * умножений (вместо n умножений при обычном подходе).
     * при не четном делаем n-1
     */
    static int sqrt(int a, int n) {
        if (n == 0) return 1;

        if (n % 2 == 1) return sqrt(a, n - 1) * a;

        int b = sqrt(a, n / 2);
        return b * b;
    }

    /*Возвидение вещественного числа «а» в степень вещественное число «n»*/
    static Double sqrt(Double a, Double n) {
        Double c = 1d;
        //не реализованно
        return c;
    }

    /**
     * @Shamil min
     * 1.2. Поиск минимального элемента в массиве
     * можно было бы метод сделать обобщенным но это не в тему и стал умничать
     * стандартный алгорит, не знаю другого O(n) - операций
     */
    static int min(int ar[]) {
        if (ar.length == 0) return 0;

        int m = ar[0];
        for (int i = 1; i < ar.length; i++)
            if (ar[i] < m) m = ar[i];
        return m;
    }

    /**
     * @Shamil average
     * 1.3. Нахождение среднего арифметического массива
     * Стандартый олгоритм не знаю другого алгоритма, где можно уменьшить О-большое т.е. уменьшить О(n)
     */
    static Double average(int ar[]) {
        int s = 0;
        if (ar.length == 0) return 0.0;

        for (int i = 0; i < ar.length; i++)
            s += ar[i];
        if (s == 0) return 0.0;

        return (double) (s / ar.length);
    }
}
