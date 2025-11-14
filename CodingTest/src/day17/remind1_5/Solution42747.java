package day17.remind1_5;

import java.util.Arrays;

public class Solution42747 {

    public static void main(String[] args) {
        Solution42747 solution42747 = new Solution42747();
        int[] arr = new int[]{3, 0, 6, 1, 5};
        int solution = solution42747.solution(arr);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] citations) {

        Arrays.sort(citations);
        int answer = 0;
        for (int i = 0 ; i < citations.length; i++) {
            int h = citations.length - i ; //5->4->3...

            // 현재 비교 논문의 인용된 횟수가 남은 논문의 개수보다 크거나 같으면
            if (citations[i] >= h) {
                // h 인덱스
                answer = h;
                break;
            }


        }
        return answer;
    }
}
