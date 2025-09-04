package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1931 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] ar = new int[N][2];
        int count = 0;

        for (int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ar[i][0] = Integer.parseInt(st.nextToken());
            ar[i][1] = Integer.parseInt(st.nextToken());
        }

        // 2) 종료 시간 ↑, 종료 같으면 시작 시간 ↑ 정렬
        Arrays.sort(ar, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });


        // 3) 그리디로 회의 선택
        int currentEnd = 0;
        for (int i = 0; i < N; i++) {
            if (ar[i][0] >= currentEnd) {
                count++;
                currentEnd = ar[i][1];
            }

        }


    }
}
