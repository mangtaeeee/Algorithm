package day17;

import java.util.*;

public class Solution42578 {

    public static void main(String[] args) {
        Solution42578 solution42578 = new Solution42578();
        String[][] strings = new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution42578.solution(strings);
    }
    public int solution(String[][] clothes) {
        int answer = 1;
        // 의상 종류와 종류별 개수를 저장하기위해 선언
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            // 맵에 Key에 의상 종류, Value에 종류별 개수를 저장
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);   // 조합 -> 안입는 경우도 고려하기 위해 + 1
        }

        answer -= 1; // 모두 '안입음'일 경우 -1 해주기

        return answer;
    }
}
