package backjun.day17;

public class Solution60057 {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));           // 7
    }


    public static int solution(String s) {
        int n = s.length(); //입력 문자열 길이 n
        if (n == 1) {       //길이가1이면 어떤 단위로 잘라도 1이 최솟값
            return 1;
        }
        int answer = n;     //초기값은 압축 안한 길이(n)로 설정

        for (int i = 1; i < n / 2; i++) { //자르는 단위 i를 1 ~ n/2까지 시도(절반초과시 반복불가의미없음)
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i); //첫조각을 기준으로 설정
            int count = 1;                   // prev랑 같은 조각이 연속된 개수 (초기 1)

            for (int j = i; j < n; j += i) { //i 칸씩 이동하며 다음 조각들을 순회
                int end = Math.min(i + j, n); //문자열 끝 경계에 넘어가지 않도록 자를 끝 인덱스 값
                String cur = s.substring(j, end); //현재 조각
                if (cur.equals(prev)) {         //현재조각이 이전 조각과 같다면 ++
                    count++;
                } else {
                    if (count > 1) {            //2번 이상 반복되었으면
                        sb.append(count);       //반복횟수 먼저 붙임 (예 : "3")
                    }
                    sb.append(prev);            //그 다음 조각 자체 붙임(예 : "sb" -> "3sb")
                    prev = cur;                 //비교 기준을 현재로 이동
                    count = 1;                  //연속 카운트 리셋
                }
            }

            //루프가 끝나면 마지막 prev 덩어리 반영
            if (count > 1) {
                sb.append(count);
            }
            sb.append(prev);
            answer = Math.min(answer, sb.length()); //이번 단위 i로 만든 압축 문자열 길이와 최소값 비교/갱신
        }
        return answer;
    }
}
