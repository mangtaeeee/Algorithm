package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//좋은수열
//백트래킹
public class Main2661 {
    static boolean endCheck = false;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        backTracking(n, 1, "");
    }

    private static void backTracking(int n, int size, String str) {
        if(endCheck){
            return;
        }
        if(size -1 == n){
            System.out.println(str);
            endCheck = true;
            return;
        }

        for(int i = 1; i <= 3; i++){
            String next = str + i;
            int len = size /2;
            boolean check = true;
            for(int j = 1; j <= len; j++){
                String a = next.substring(size - j, size);
                String b = next.substring(size - j - j, size - j);
                if(a.equals(b)){
                    check = false;
                    break;
                }
            }
            if(!check){
                continue;
            }
            else {
                backTracking(n, size + 1, next);
            }
        }

    }
}
