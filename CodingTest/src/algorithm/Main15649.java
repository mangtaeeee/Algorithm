package algorithm;


import java.util.Scanner;

public class Main15649 {

    static int[] arr;
    static boolean[] visit;

    public static void main(String[]args){

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        //M 까지의 값을담기위한 선언
        arr = new int[M];
        //N 만큼의 수를 확인하기 위한 선언
        visit = new boolean[N];
        
        dfs(N,M,0);
    }

    private static void dfs(int N, int M, int dept) {
        //탐색을 위한 count 가 M 과 같아지면
        if(dept == M){
            //arr[] 안에 값을 반복을 통해 출력
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < N; i++){
            //만약 방분하지 않았으면
            if(!visit[i]){
                visit[i] = true;
                //현재의 탐색을 완료한 count 에 i+1 의 값을 넣어서 저장
                arr[dept] = i + 1;
                dfs(N,M,dept + 1);
                visit[i] = false;
            }
        }
    }

}
