package src.algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14889 {

    //행과 열의 개수를 입력 받기위한 변수
    static int N;
    //행과열을 저장하기 위한 변수
    static int[][] map;
    //확인을했는지 방문을 위한 변수
    static boolean[] visit;
    //값을 저장하기 위해 가장 높은 값을 처음 초기화해 저장
    static int Min = Integer.MAX_VALUE;

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //행열 값을 받아
        N = Integer.parseInt(br.readLine());
        //map에 행열 초기화
        map = new int[N][N];
        //행의 확인을 위한 초기화
        visit = new boolean[N];
        for(int i = 0; i < N; i++){
            // 공백을 기준으로 토큰으로 나눠서
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N ;j++){
                // int 형변환 후 행열값에 수만큼 담음
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0, 0);
        System.out.println(Min);

    }
    // idx는 인덱스, count는 조합 개수(=재귀 깊이)
    static void combi(int idx, int count) {
        if(count == N/2){
            diff();
            return;
        }
        for(int i = idx; i< N; i++){
            //방문하지 않았다면?
            if(!visit[i]){
                visit[i] = true; // 방문으로변경
                combi(i + 1, count +1);
                visit[i] = false;// 재귀가 끝나면 미방문으로 변경
            }
        }
    }

    //두 팀의 능력치 차이를 계산하는 함수
    static void diff(){
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N-1; i++){
            for (int j = i + 1; j < N; j++){
                //i번째 사람과 j 번째 사람이 true 라면 스타트팀으로 점수 플러스
                if(visit[i] == true && visit[j] == true){
                    team_start += map[i][j];
                    team_start += map[i][j];
                }
                //i번째 사람과 j번째 사람이 false라면 링크팀으로 점수 플러스
                else if(visit[i] == false && visit[j] == false){
                    team_link += map[i][j];
                    team_link += map[i][j];
                }
            }
        }
        //두팀의 점수 차이 (절대값)
        int val = Math.abs(team_start - team_link);

        /*
            두 팀의 점수차가 0이라면 가장 낮은 최속값이기 때문에
            더이상의 탐색 필요없이 0을 출력하고 종료하면 된다.
        * */
        if(val == 0){
            System.out.println(val);
            System.exit(0);
        }
        Min = Math.min(val, Min);
    }
}

