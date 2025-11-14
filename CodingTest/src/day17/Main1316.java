package day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main1316 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i ++) {
            String word = br.readLine();
            if (isGroup(word)) {
                count ++;
            }
        }

        System.out.println("count = " + count);
    }

    private static boolean isGroup(String word) {
        Set<Character> characterSet = new HashSet<>(); // 중복을제거하고 단어를 담기위한 Set
        char prev = word.charAt(0); // 첫번째 단어
        characterSet.add(prev);

        for (char c : word.toCharArray()) {
            //첫 문자와 다르면
            if (c != prev) {
                if (characterSet.contains(c)) {
                    return false;
                }
                characterSet.add(c);
                prev = c; //이전 단어 저장
            }
        }
        return true;
    }
}
