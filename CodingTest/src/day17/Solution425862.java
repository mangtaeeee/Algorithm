package day17;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution425862 {

    public static void main(String[] args) {
        Solution425862 solution42586 = new Solution425862();
        int[] a = new int[]{93, 30, 55};
        int[] b = new int[]{1, 30, 5};

        ArrayList<Integer> solution = solution42586.solution(a, b);
        System.out.println("solution = " + solution);
    }
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        // 정답을 담을 배열
        ArrayList<Integer> answer = new ArrayList<>();

        Deque<Integer> queue = new LinkedList<>();

        for (int i =0; i < progresses.length ; i ++) {
            //(100 - 현재진척도) / 속도
            queue.add((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        int count = 1;
        System.out.println("queue = " + queue);

        int first = queue.poll();
        System.out.println("first = " + first);

        while (!queue.isEmpty()) {
            //첫째 값을 제외한 값
            int current = queue.poll();
            if (first >= current) {
                count ++;
                System.out.println("count = " + count);
            } else {
                answer.add(count);
                // 다음 값으로 초기화
                first = current;
                count = 1;
            }
        }
        // else count 추가
        answer.add(count);

        return answer;
    }
}
