package algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888 {
    static int Max = Integer.MIN_VALUE; // 출력을 위한 최댓값
    static int Min = Integer.MAX_VALUE; // 출력을 위한 최솟값
    static int[] operator = new int[4]; // 연산자를 위한 선언
    static int[] number ; // 수를 입력받기위해 선언
    static int N ; // 수의 개수



    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // number의 개수 받아
        N = Integer.parseInt(br.readLine());
        // 개수 만큼 크기 선언 후
        number = new int[N];
        // 토큰으로 나누기 위한 토큰 선언
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < N; i ++){
            // number의 길이만큼 입력 받음
            number[i] = Integer.parseInt(st.nextToken());
        }
        //연산자 입력을 위해 토큰 초기화
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < operator.length; i ++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);
        System.out.println(Max); //최댓값
        System.out.println(Min); //최솟값


    }

    public static void dfs(int num, int count){
        // 재귀 호출후 count 가 N과 같다면
        if (count == N){
            //num에 저장된 값과 max의 값중 높은 값을 저장
            Max = Math.max(Max, num);
            //num에 저장된 값과 min의 값중 더 낮은 값을 저장
            Min = Math.min(Min, num);
            return;
        }

        for(int i = 0; i < 4 ; i++){
            //operator의 값이 0보다 높다면
            if(operator[i] > 0){
                //담겨있는 operator의 값을 차감 후
                operator[i]--;

                switch(i){
                    case 0:
                        dfs(num + number[count], count + 1);
                        break;
                    case 1:
                        dfs(num - number[count], count + 1);
                        break;
                    case 2:
                        dfs(num * number[count], count + 1);
                        break;
                    case 3:
                        dfs(num / number[count], count + 1);
                        break;
                }
                //재귀 호출 종료시 다시 해당 연산자 복구
                operator[i] ++;
            }
        }
    }
}
