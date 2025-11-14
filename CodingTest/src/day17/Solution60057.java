package day17;

public class Solution60057 {

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }

    private static int solution(String s) {
        int answer = s.length(); // 최악은 압축이 안되고 문자의 길이 자체

        for (int size = 1; size < s.length() ; size++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, size);         //첫 조각
            int count = 1;

            // size 단위씩 끊어가며 비교
            for (int i = size ; i + size <= s.length() ;i ++) {
                String now = s.substring(i , i + size);

                //이전 조각과 같으면 count 증가
                if (prev.equals(now)) {
                    count ++;
                } else {
                    //다르면 압축된 문자열에 추가
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(prev);
                    // 이전값 변경
                    prev = now;
                    //count 초기화
                    count = 1;
                }

            }

            // 마지막 남은 조각 처리
            if (count > 1) {
                sb.append(count);
            }
            sb.append(prev);
            // 잘린 나머지(끝부분)에 대한 처리
            if (s.length() % size != 0) {
                sb.append(s.substring(s.length() - (s.length() % size)));
            }

            answer = Math.min(answer, sb.length());
        }
        return answer;
    }

}
