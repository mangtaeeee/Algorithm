package programmers.LV2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution60057 {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));           // 7
    }


    public static int solution(String s) {

        // 문자열이 아주 짧으면 그대로가 최소
        if(s.length() <= 1) {
            return s.length();
        }
        int answer = s.length(); // 일단 최악(그대로 길이)저장

        //자르는크기 : 1 ~ (길이 /2)
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder result = new StringBuilder();

            String prev = s.substring(0, i); // 첫 조각
            int count = 1; //prev의 반복 횟숫

            //i만큼 점프하면서 다음 값 과 비교
            for (int j = i; j <= s.length(); j += i) {
                String next;
                if (j + i <= s.length()) {
                    next = s.substring(j, j + i);  //딱 i만큼
                } else {
                    next = s.substring(j); // 끝부분(남은 조각)
                }

                if (prev.equals(next)) {
                    // 같으면 반복 카운트 증가
                    count ++;
                } else {
                    // 다르면 지금까지의 prev를 적는다
                    if (count > 1) {
                        result.append(count); // 2이상일 때만 숫자 붙임
                    }
                    result.append(prev);

                    // 새 시작
                    prev = next;
                    count = 1;
                }
            }
            result.append(prev);
            // 최소 길이 갱신
            answer = Math.min(answer, result.length());

        }

        return answer;
    }
}
