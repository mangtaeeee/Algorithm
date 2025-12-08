package day17;

import java.util.HashMap;
import java.util.Map;

public class Solution42557 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (String s : phone_book) {
            stringIntegerMap.put(s, 1);
        }

        for (String s : phone_book) {
            for (int j = 0; j < s.length(); j++) {
                if (stringIntegerMap.containsKey(s.substring(0, j))) {
                    return false;
                }
            }
        }


        return answer;
    }
}
