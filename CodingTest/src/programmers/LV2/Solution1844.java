package programmers.LV2;

import backjun.Main2178;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1844 {

    static int answer = -1;
    //행열
    static int N,M;

    // 상하 좌우 이동방향
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited ;
    public int solution(int[][] maps) {
        N = maps.length;
        M = Arrays.stream(maps).toArray().length;
        visited = new boolean[N][M];
        return bfs(0,0,maps);
    }

    static int bfs(int startX, int startY,int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY , 1));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();


            if(p.x == N - 1 && p.y == M - 1) {
                return p.count;
            }

            //4방향 탐색
            for (int i = 0 ; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < N && ny >=0 && ny < M) {
                    if(!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny, p.count + 1));
                    }
                }
            }

        }

        return answer;
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
