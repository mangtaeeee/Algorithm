package programmers.LV2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
//또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
// 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
//먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
// 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇
// 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
//  progresses	  speeds	return
// [93, 30, 55]	[1, 30, 5]	[2, 1]
public class Solution42586 {

    public static void main(String[] args) {
        Solution42586 solution42586 = new Solution42586();
        int[] a = new int[]{93, 30, 55};
        int[] b = new int[]{1, 30, 5};

        ArrayList<Integer> solution = solution42586.solution(a, b);
        System.out.println("solution = " + solution);
    }
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        //결과를 반환할 int형을 담는 ArrayList answer 선언
        // progresses의 각 인덱스 값이 100을 넘는 최소일수를 담을 Queue queue선언
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            //progresses의 길이만큼 for문을 돌면서 ,
            //progresses 각 인덱스 값이 100을 넘기 위한 최소일수 계산 후 queue에 add 메소드로 넣기
            queue.add((int)Math.ceil((100.0-progresses[i])/speeds[i]));
        }

        int count = 1;
        int first = queue.poll();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (first >= current) {
                count ++;
            } else {
                answer.add(count);
                count = 1;
                first = current;
            }
        }
        answer.add(count);

        return answer;
    }
}
