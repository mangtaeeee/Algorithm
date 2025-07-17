package algorithm;

import java.util.*;

public class Main120880 {

    public static void main(String[] args) {
        Main120880 sol = new Main120880();
        int[] numlist = {1, 2, 3, 4, 5};
        int n = 3;
        int[] result = sol.solution(numlist, n);
        System.out.println(Arrays.toString(result)); // [3, 4, 2, 5, 1]
    }

    public int[] solution(int[] numlist, int n) {
        int [] answer = new int[numlist.length];

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : numlist) {
            list.add(num);
        }
        list.sort((a, b) -> {

            int distanceA = Math.abs(a - n);
            int distanceB = Math.abs(b - n);
            if (distanceA == distanceB) {
                return b - a; // 거리가 같으면 더 큰 수가 앞에 오도록
            }
            return distanceA - distanceB; // 거리가 가까운 순서대로 정렬
        });
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
