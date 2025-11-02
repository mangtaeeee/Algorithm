package programmers.LV2;

import java.util.*;

public class Solution42577 {


    public static void main(String[] args) {
        String[] s = new String[]{"123","456","789"};
        Solution42577 solution42577 = new Solution42577();
        System.out.println("solution42577.solution(s) = " + solution42577.solution(s));
    }

    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (String phone : phone_book) {
            for (int j = 0; j < phone.length(); j++) {
                if (map.containsKey(phone.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }
}
