package day17;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution42587 {

    public static void main(String[] args) {
        Solution42587 solution42587 = new Solution42587();
        int solution = solution42587.solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int priority : priorities) {
            priorityQueue.add(priority);
        }

        while (!priorityQueue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                // 현재 문서가 가장 높은 우선순위인 경우
                if(priorities[i] == priorityQueue.peek()) {
                    priorityQueue.poll();     // 꺼냄
                    answer++;      // 출력된 문서 수 증가
                    if(i == location) {
                        // 찾는 문서라면
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}
