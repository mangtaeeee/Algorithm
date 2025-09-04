package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackTracking {
    static int N ;
    static int[] number;


    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        number = new int[N];

        for(int i = 0 ; i < N; i++){
            number[i] = Integer.parseInt(br.readLine());
        }

    }

    public static void dfs(int[][] number, int count, int[][] result, int[] history) {
        if(count == number.length){

        }
    }

}
