package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution42576 {

    public static void main(String[] args) {
        Solution42576 solution42576 = new Solution42576();
        String[] st1 = new String[]{"leo", "kiki", "eden"};
        String[] st2 = new String[]{"eden", "kiki"};
        String solution = solution42576.solution(st1, st2);
        System.out.println("solution = " + solution);
    }
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();

        String answer = "";
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                answer = s;
            }
        }
        return answer;

    }

}
