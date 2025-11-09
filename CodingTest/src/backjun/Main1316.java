package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//    그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
//    예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
//    aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
//    단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
//    입력
//    첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다.
//    둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
public class Main1316 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) {
                count++;
            }
        }

        System.out.println(count);

    }

    private static boolean isGroupWord(String word) {

        Set<Character> characterSet = new HashSet<>();
        char prev = word.charAt(0);
        characterSet.add(prev);

        for (char c : word.toCharArray()) {
            //이전문자와 다르면
            if (c != prev) {
                if (characterSet.contains(c)) {
                    return false; // 이미 등장한 문자면 그룹 단어 아님
                }
                characterSet.add(c); // 이전 문자 기록
                prev = c;
            }
        }
        return true;
    }

}
