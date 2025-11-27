package day17.remind1_5;

public class Main2667 {

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



    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;
        for (int dir = 0; dir < 4; dir ++){
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
