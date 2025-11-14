package day17;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution42587 {

    public static void main(String[] args) {
        Solution42587 solution42587 = new Solution42587();
        int[] arr = new int[] {1, 1, 9, 1, 1, 1};
        int solution = solution42587.solution(arr, 0);
        System.out.println("solution = " + solution);
    }
    public int solution(int[] priorities, int location) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            pq.add(priority);
        }
        int answer = 0;

        while (!pq.isEmpty()) {
            for (int i = 0 ; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}
