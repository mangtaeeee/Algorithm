package day17;

import day17.remind1week.Solution42577;

import java.util.HashMap;
import java.util.Map;

public class Solution42578 {



    public static void main(String[] args) {
        Solution42578 solution42578 = new Solution42578();
        String[][] strings = new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int solution = solution42578.solution(strings);
        System.out.println("solution = " + solution);
    }



    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] clothe : clothes) {
            clothesMap.put(clothe[1], clothesMap.getOrDefault(clothe[1], 0) + 1);
        }
        for (String key : clothesMap.keySet()) {
            answer *= (clothesMap.get(key) + 1 );
        }


        return answer - 1;
    }
}
