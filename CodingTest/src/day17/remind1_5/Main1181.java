package day17.remind1_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main1181 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0 ; i < N; i++) {
            String word = br.readLine();
            if (!list.contains(word)) {
                list.add(word);
            }
        }

        list = list.stream()
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
