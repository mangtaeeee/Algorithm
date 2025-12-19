package day17.remind2week;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution42587 {


    public static void main(String[] args) {
        day17.Solution42587 solution42587 = new day17.Solution42587();
        int solution = solution42587.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 내림 차순 우선순위 정렬 큐 선언
        // 가장 높은 우선순위를 빠르게 알기 위해
        // 내림차순 PriorityQueue 사용
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<>(Collections.reverseOrder());

        // 모든 문서의 우선순위를 큐에 저장
        for (int priority : priorities) {
            priorityQueue.add(priority);
        }

        // 우선순위 큐가 빌 때까지 반복
        // (모든 문서가 출력될 때까지)
        while (!priorityQueue.isEmpty()) {

            // 현재 대기열을 앞에서부터 순회
            for (int i = 0; i < priorities.length; i++) {

                // 현재 문서의 우선순위가
                // 전체 문서 중 가장 높은 우선순위라면 출력
                if (priorityQueue.peek() != null && priorities[i] == priorityQueue.peek()) {

                    priorityQueue.poll(); // 가장 높은 우선순위 제거
                    answer++;             // 출력 순서 증가

                    // 출력된 문서가 내가 찾는 문서라면
                    // 현재 출력 순서 반환
                    if (i == location) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

}
