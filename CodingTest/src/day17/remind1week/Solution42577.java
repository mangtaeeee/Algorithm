package day17.remind1week;

import java.util.HashMap;
import java.util.Map;

public class Solution42577 {

    public static void main(String[] args) {
        Solution42577 solution42577 = new Solution42577();
        boolean solution = solution42577.solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println("solution = " + solution);
    }
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> phoneBookMap = new HashMap<>();
        for (String phoneNumber : phone_book) {
            phoneBookMap.put(phoneNumber, 1);
        }

        for (String phoneNumber : phone_book) {
            for (int i = 0 ; i < phoneNumber.length(); i ++) {
                if (phoneBookMap.containsKey(phoneNumber.substring(0, i))) {
                    return false;
                }
            }
        }
        return answer;
    }
}
