package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
public class Main1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 중복 제거 및 정렬
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("uniqueWords = " + uniqueWords);
        String[] sortedWords = uniqueWords.stream()
                .sorted((a, b) -> {
                    if (a.length() == b.length()) {
                        return a.compareTo(b); // 길이가 같으면 사전순 정렬
                    }
                    return Integer.compare(a.length(), b.length()); // 길이로 정렬
                })
                .toArray(String[]::new);

        // 출력
        for (String word : sortedWords) {
            System.out.println(word);
        }

    }
}
