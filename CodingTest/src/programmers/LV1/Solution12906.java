package programmers.LV1;

import java.util.*;

public class Solution12906 {

    public static void main(String[] args) {
        Solution12906 solution12906 = new Solution12906();
        int[] arr = {4,4,4,3,3};
        solution12906.solution(arr);
    }

    public Stack<Integer> solution(int []arr) {

        Stack<Integer> answerStack = new Stack<>();
        for (int j : arr) {
            if (!answerStack.empty()) {
                if (answerStack.peek() == j) {
                    answerStack.pop();
                }
            }
            answerStack.add(j);
        }


        return answerStack;
    }
}
