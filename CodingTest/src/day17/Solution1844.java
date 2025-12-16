package day17;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1844 {

    // 맵의 세로 길이(행), 가로 길이(열)
    static int N, M;

    //방문여부
    static boolean[][] visited;
    //상하
    static int[] dx = new int[]{-1, 1, 0, 0};
    //좌우
    static int[] dy = new int[]{0, 0, -1, 1};

    static int answer = -1;

    public int solution(int[][] maps) {
        //행
        N = maps.length;
        //열 값
        M = maps[0].length;
        //같은 행열을 가진 방문 여부 선언
        visited = new boolean[N][M];

        return bfs(0, 0, maps);
    }

    //시작 행,열, 맵 매개변수로 받음
    static int bfs(int startX, int startY, int[][] maps) {
        Deque<Point> queue = new ArrayDeque<Point>();
        //첫 값으로 queue에 적재
        queue.offer(new Point(startX, startY, 1));
        visited[startX][startY] = true;

        // 큐가 비어있지 않은 동안 반복
        while (!queue.isEmpty()) {

            //큐 맨앞에 값 추출 후 삭제
            Point point = queue.poll();

            //행 과 열 모두 탐색했을때
            if (point.x == N - 1 && point.y == M - 1) {
                return point.count;
            }
            // 상, 하, 좌, 우 네 방향으로 이동 시도
            for (int i = 0; i < 4; i++) {

                // 현재 위치(point)에서 다음 위치 계산
                int nx = point.x + dx[i];   // 다음 행 좌표
                int ny = point.y + dy[i];   // 다음 열 좌표

                // 맵 범위를 벗어나지 않았는지 확인
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {

                    // 아직 방문하지 않았고, 이동 가능한 칸(1)이라면
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {

                        // 해당 칸을 방문 처리 (중복 방문 방지)
                        visited[nx][ny] = true;

                        // 다음 위치를 큐에 추가
                        // 현재 거리(point.count)에 +1 해서 이동 거리 누적
                        queue.add(new Point(nx, ny, point.count + 1));
                    }
                }
            }
        }

        return answer;

    }

    static class Point {
        int x, y, count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }


}
