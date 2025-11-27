package day17.remind1_5;

public class Solution60057 {
    public static void main(String[] args) {
        System.out.println(solution("ababcdcdababcdcd"));
    }


    public static int solution(String s) {
        int answer = s.length();

        for (int size = 1 ; size < s.length() / 2; size++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, size);
            int count = 1;

            for (int i = size ; i + size <= s.length(); i ++) {
                String now = s.substring(i, i + size);

                if (prev.equals(now)) {
                    count++;
                } else {
                    if(count > 1) {
                        sb.append(count);
                    }
                    sb.append(prev);

                    prev = now;

                    count = 1;
                }
            }

            if (count > 1) {
                sb.append(count);
            }
            sb.append(prev);

            if (s.length() % size != 0) {
                sb.append(s.substring(s.length() - (s.length() % size)));
            }

            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
