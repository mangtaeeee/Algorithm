package day17;

import java.util.Arrays;

public class Solution42746 {

    public static void main(String[] args) {
        Solution42746 solution42746 = new Solution42746();
        int[] num = new int[]{6, 10, 2};
        solution42746.solution(num);
    }
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];

        for (int i = 0 ; i < numbers.length ; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, (a, b) -> (b+a).compareTo(a+b));
        return str[0].equals("0") ? "0" : String.join("", str);
    }
}
