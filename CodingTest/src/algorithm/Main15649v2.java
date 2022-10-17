package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15649v2 {
    static int[] arr; //값을 담을 배열
    static boolean[] visit; //방문 여부
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //결과값에 길이를 M 적용
        arr = new int[M];
        //길이만큼 확인을 위해 N 길이수 넣어줌
        visit = new boolean[N];

        dfs(N,M,0);
        System.out.println(sb);




    }

    public static void dfs(int N, int M, int count) {
        if(count == M){
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
        }
        for (int i = 0 ; i < N; i++){
            //만약 visit 의 값이 true와 같지 않다면
            if(!visit[i]){
                //visit[i]를 true로 변경
                visit[i] = true;
                //arr[현재 count] 처음은 0
                arr[count] = i + 1; // 처음 기준으로 0+1 인 1을담고
                //다시 재귀 호출
                dfs(N,M,count+1);
                visit[i] = false;
            }
        }
    }
}
