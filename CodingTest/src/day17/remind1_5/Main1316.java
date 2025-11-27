package day17.remind1_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1316 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0 ; i < N; i ++) {
            String word = br.readLine();
            if (isWord(word)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isWord(String word) {
        Set<Character> characterSet = new HashSet<>();
        char prev = word.charAt(0);
        characterSet.add(prev);

        for (char c : word.toCharArray()) {
            if (prev != c) {
                if (characterSet.contains(c)) {
                    return false;
                }
            }
            characterSet.add(prev);
            prev = c;
        }
        return true;
    }

}
