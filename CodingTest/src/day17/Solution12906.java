package day17;

import java.util.*;

public class Solution12906 {
    public static void main(String[] args) {
        Solution12906 solution12906 = new Solution12906();
        Deque<Integer> solution = solution12906.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        System.out.println("solution = " + solution);
    }
    public Deque<Integer> solution(int []arr) {
        Deque<Integer> integers = new ArrayDeque<>();
        for (int i : arr) {
            if (integers.isEmpty() || integers.getLast() != i) {
                integers.add(i);
            }
        }


        return integers;
    }
}
