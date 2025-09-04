package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.IntStream;

public class Main11399 {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> ar = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < N ; i++) {
            ar.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(ar);
        int running = 0;
        int total = 0;

        for (int num : ar) {
            running += num;
            total += running;
        }
        System.out.println(total);




    }
}
