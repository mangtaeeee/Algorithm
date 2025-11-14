package day17.remind1_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> strings = new HashSet<>();
        for (int i = 0 ;i < N; i++) {
            strings.add(br.readLine());
        }

        List<String> list = strings.stream()
                .sorted((a, b) -> {
                    if (a.length() == b.length()) {
                        return a.compareTo(b);
                    }
                    return Integer.compare(a.length(), b.length());
                }).toList();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
