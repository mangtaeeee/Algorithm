package programmers.LV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length ; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int idx = commands[i][2];
            List<Integer> temp = new ArrayList<>();
            for (int j = start-1; j < end ; j++) {
                temp.add(array[j]);
            }

            temp.sort(Integer::compareTo);
            answer[i] = temp.get(idx-1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution42748 sol = new Solution42748();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = sol.solution(array, commands);
        System.out.println("result = " + Arrays.toString(result));
    }
}
