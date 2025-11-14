package day17.remind1_5;

public class Solution60057 {

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));           // 7
    }


    public static int solution(String s) {
        int n = s.length();         //입력 문자열의 길이
        if (n == 1) {
            return 1;
        }
        int answer = n;

        for (int i = 0 ; i < n /2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0 , i);
            int count = 1;

            for (int j = 0 ; j < n ; j += i) {
                int end = Math.min(i+j, n);
                String sur = s.substring(j, end);
                if (sur.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(prev);
                    prev = sur;
                    count = 1;
                }
            }

            if (count > 1) {
                sb.append(count);
            }
            sb.append(prev);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
