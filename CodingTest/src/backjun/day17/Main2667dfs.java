package backjun.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2667dfs {

    //아파트 단지
    static int[][] danji;
    //방문 여부
    static boolean[][] visited;
    // 상하좌우 이동 방향
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    // 입력 받을 단지의 수
    static int N;
    //현재 단지의 집 개수 현재행의 1값
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        danji = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0 ; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0 ; j < N; j++) {
                danji[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

    }

    static void dfs(int x, int y) {
        //방문처리
        visited[x][y] = true;
        //집 개수증가
        count++;

        for (int dir = 0 ; dir < 4; dir ++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (danji[nx][ny] == 1 && visited[nx][ny]) {
                    dfs(nx, ny); // 연결된 다른 집 재귀 호출
                }
            }
        }


    }
}
