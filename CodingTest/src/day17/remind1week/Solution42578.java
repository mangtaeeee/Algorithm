package day17.remind1week;

import java.util.HashMap;
import java.util.Map;

public class Solution42578 {

    public static void main(String[] args) {
        Solution42578 solution42578 = new Solution42578();
        String[][] strings = new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution42578.solution(strings);
    }

    public int solution(String[][] clothes) {

        int answer = 1;

        Map<String, Integer> clothesMap = new HashMap<>();
        for (String[] clothe : clothes) {
            // 맵에 Key에 의상 종류, Value에 종류별 개수를 저장
            clothesMap.put(clothe[1], clothesMap.getOrDefault(clothe[1], 0) + 1);
        }

        for(String key : clothesMap.keySet()) {
            answer *= (clothesMap.get(key) + 1);   // 조합 -> 안입는 경우도 고려하기 위해 + 1
        }

        //headgear = 2개 → (2 + 1) = 3
        //입을 수 있는 경우: 모자1, 모자2, 안 씀
        //eyewear = 1개 → (1 + 1) = 2
        //선글라스, 안 씀
        //전체 조합: 3 * 2 = 6
        answer -= 1;

        return answer;
    }
}
