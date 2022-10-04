package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main8958 {
//    "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
//    문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
//    "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
//    OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 테스트 케이스

        String arr[] = new String[N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = br.readLine();
        }

        for(int i = 0 ; i < N ; i++){
            int cnt = 0; //연속 횟수
            int sum = 0; //누적 합산

            for(int j = 0 ;j < arr[i].length(); j++){

                if(arr[i].charAt(j) == 'O'){
                    cnt++;
                } else {
                    cnt = 0;
                }
                sum += cnt;
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}