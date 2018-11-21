import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: Roman to Integer
 * Date: 2018-11-20
 */
public class Solution {
    private static final String REGEX = "(?!^)";

    public static int romanToInt(String s) {
        String[] letters = s.split(REGEX);
        int[] values = new int[letters.length];
        for (int i = 0; i < letters.length; i++) {
            values[i] = RomanNumber.valueOf(letters[i]).getValue();
        }
        System.out.println(Arrays.toString(values));
        int maxIndex = findMaxIndex(values);
        System.out.println(maxIndex);
        if (values.length == 1) {
            return RomanNumber.valueOf(letters[0]).getValue();
        }
        int rev = RomanNumber.valueOf(letters[maxIndex]).getValue();
        for (int i = maxIndex + 1; i < letters.length; i++) {
            rev += RomanNumber.valueOf(letters[i]).getValue();
        }
        if (maxIndex != 0) {
            for (int i = 0; i < maxIndex; i++) {
                rev -= RomanNumber.valueOf(letters[i]).getValue();
            }
        }
        return rev;
    }

    private static int findMaxIndex(int[] values) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if (max < values[i]) {
                max = values[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        String s = "IV";
        System.out.println(romanToInt(s));
//        System.out.println(RomanNumber.valueOf(s).getValue());
    }

    enum RomanNumber {
        I("I", 1), V("V", 5), X("X", 10), L("L", 50), C("C", 100), D("D", 500), M("M", 1000);

        private int value;
        private String content;

        RomanNumber(String s, int i) {
            this.content = s;
            this.value = i;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }


}
