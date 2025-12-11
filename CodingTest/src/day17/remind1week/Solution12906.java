package day17.remind1week;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution12906 {

    public static void main(String[] args) {
        Solution12906 solution12906 = new Solution12906();
        Deque<Integer> solution = solution12906.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        System.out.println("solution = " + solution);
    }

    public Deque<Integer> solution(int[] arr) {
        Deque<Integer> answer = new ArrayDeque<>();

        for (int number : arr) {
            if (answer.isEmpty() || answer.getLast() != number) {
                answer.add(number);
            }
        }

        return answer;
    }
}
