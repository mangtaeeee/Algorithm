package day17.remind1week;

import java.util.HashMap;
import java.util.Map;

public class Solution42576 {

    public static void main(String[] args) {
        Solution42576 solution42576 = new Solution42576();
        String[] st1 = new String[]{"leo", "kiki", "eden"};
        String[] st2 = new String[]{"eden", "kiki"};
        String solution = solution42576.solution(st1, st2);
        System.out.println(solution);
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();

        for (String s : participant) {
            participantMap.put(s, participantMap.getOrDefault(s, 0) + 1);
        }

        for (String name : completion) {
            participantMap.put(name, participantMap.getOrDefault(name, 0) - 1);
        }
        String answer = "";

        for (Map.Entry<String, Integer> stringIntegerEntry : participantMap.entrySet()) {
            if (stringIntegerEntry.getValue().equals(1)) {
                answer = stringIntegerEntry.getKey();
            }
        }
        return answer;
    }
}
