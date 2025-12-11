package day17.remind1week;

import java.util.Arrays;

public class Solution42746 {

    public static void main(String[] args) {
        Solution42746 solution42746 = new Solution42746();
        int[] num = new int[]{6, 10, 2};
        solution42746.solution(num);
    }

    public String solution(int[] numbers) {

        String[] strings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strings,((a, b) -> (b+a).compareTo(a+b)));
        StringBuilder answer = new StringBuilder();

        for (String string : strings) {
            answer.append(string);
        }

        return answer.toString();
    }
}
