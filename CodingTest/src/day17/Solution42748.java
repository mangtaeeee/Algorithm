package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution42748 {

    static int start ;
    static int end ;
    static int number;

    public static void main(String[] args) {
        Solution42748 solution42748 = new Solution42748();
        int[] num = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] com = new int[][]{{2, 5, 3}, {4,4,1}, {1,7,3}};
        ArrayList<Integer> solution = solution42748.solution(num, com);
        System.out.println("solution = " + solution);
    }

    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();

        for (int[] command : commands) {
            start = command[0];
            end = command[1];
            number = command[2];

            for (int j = start - 1; j < end; j++) {
                integerArrayList.add(array[j]);
            }
            integerArrayList.sort(Comparator.naturalOrder());
            answer.add(integerArrayList.get(number - 1));
            integerArrayList = new ArrayList<>();
        }


        return answer;
    }

}
