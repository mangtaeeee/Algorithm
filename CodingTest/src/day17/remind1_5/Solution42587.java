package day17.remind1_5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution42587 {

    public static void main(String[] args) {
        Solution42587 solution42587 = new Solution42587();
        int[] arr = new int[] {1, 1, 9, 1, 1, 1};
        int solution = solution42587.solution(arr, 0);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int priority : priorities) {
            priorityQueue.add(priority);
        }
        int answer = 0;

        while (!priorityQueue.isEmpty()) {
            for (int i = 0 ; i < priorities.length; i ++) {
                if (priorityQueue.peek() == priorities[i]) {
                    priorityQueue.poll();
                    answer ++;
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}
