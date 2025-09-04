package programmers.LV2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수,
solution을 완성하세요.
예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

제한 조건
s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
* */
public class Solution12939 {

    public static void main(String[] args) throws Exception {
        Solution12939 solution = new Solution12939();
        String solution1 = solution.solution("1 2 3 4");
        System.out.println(solution1);
    }


    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int stCount = st.countTokens();
        int[] arr = new int[stCount];

        for (int i = 0; i < stCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        return arr[0] +" "+ arr[stCount-1];
    }
}
