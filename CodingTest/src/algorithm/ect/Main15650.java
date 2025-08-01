package algorithm.ect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15650 {
    static int[] arr;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1,0);
        System.out.println(sb);
    }
    public static void dfs(int num, int count){
        if(count == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i = num; i <= N ; i++){
            arr[count] = i ;
            dfs(i + 1, count+1);
        }
    }
}
