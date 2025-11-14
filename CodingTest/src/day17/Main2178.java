package day17;

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
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY , 1));
        //방문 처리
        visited[startX][startY] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x == N - 1 && p.y == M - 1) {
                return p.count;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny, p.count + 1));
                    }
                }

            }


        }
        return -1;
    }

    static class Point {
        int x, y, count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
