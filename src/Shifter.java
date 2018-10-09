public class Shifter {
    /*
Метод shifter (перевертыш) сделал статик т.к. не относится по смыслу к данному классу
 */
    static String shifter(String s) {
        StringBuilder sh = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sh.append(s.charAt(i));
        }
        return sh.toString();
    }
}
