package day17;

import java.util.HashMap;
import java.util.Map;

public class Solution42577 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String , Integer> phoneBookMap = new HashMap<>();

        for (String phoneNumber : phone_book) {
            phoneBookMap.put(phoneNumber , 1);
        }

        for (String phoneNumber : phone_book) {
            for (int i = 0 ; i < phoneNumber.length(); i ++) {
                if (phoneBookMap.containsKey(phoneNumber.substring(0,i))) {
                    return false;
                }
            }
        }

        return answer;
    }
}
