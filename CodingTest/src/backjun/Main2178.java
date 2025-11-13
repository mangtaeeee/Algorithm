package backjun;

import java.util.*;
import java.io.*;

public class Main2178 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    // 상하좌우 이동 방향
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        // 미로 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    // BFS로 최단 경로 탐색
    static int bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY, 1));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // 도착 지점에 도달했으면 이동 칸 수 반환
            if (p.x == N - 1 && p.y == M - 1) {
                return p.count;
            }

            // 4방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];

                // 범위 체크 & 방문하지 않았으며 길(1)이면
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny, p.count + 1));
                    }
                }
            }
        }

        // 도달할 수 없는 경우 (문제 조건상 항상 도달 가능)
        return -1;
    }

    // 큐에 저장할 때 위치(x,y)와 지금까지 이동한 칸 수(count)를 함께 저장
    static class Point {
        int x, y, count;
        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    '}';
        }
    }
}