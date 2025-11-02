package programmers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 1, 2, 2, 2, 3};
        int i = solution.Solution11(arr);
        System.out.println("i = " + i);
    }
    public int Solution11(int[] arr){

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i ++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return map.entrySet().stream()
                .sorted((a, b) -> {
                    int cmp = Integer.compare(b.getValue() , a.getValue());
                    if (cmp == 0) {
                        return Integer.compare(a.getKey(), b.getKey());
                    }
                    return cmp;
                })
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }
}
