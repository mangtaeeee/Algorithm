package day17.remind1_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i ++) {
            String word = br.readLine();
            if (isGroup(word)) {
                count++;
            }

        }

        System.out.println(count);

    }

    private static boolean isGroup(String word) {

        Set<Character> characterSet = new HashSet<>();
        char prev = word.charAt(0);
        characterSet.add(prev);

        for (char c : word.toCharArray()) {
            if (c != prev) {
                if (characterSet.contains(c)) {
                    return false;
                }
                characterSet.add(c);
                prev = c;
            }
        }

        return true;
    }
}
