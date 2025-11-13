package backjun.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {

    /// 줄 정수
    static int N, M;
    //미로
    static int[][] maze;
    //방문 여부
    static boolean[][] visited;
    //상하 좌우 이동방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        //미로 입력
        for (int i = 0; i < N ; i ++) {
            String line = br.readLine();
            for (int j = 0 ; j < M; j ++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println("bfs = " + bfs(0, 0));

    }

    static int bfs (int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        //방문 처리
        visited[startX][startY] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int cx = now[0];
            int cy = now[1];

            if (cx == N - 1 && cy == M - 1) {
                return count;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        count = count + 1;
                    }
                }

            }


        }
        return -1;
    }
}
