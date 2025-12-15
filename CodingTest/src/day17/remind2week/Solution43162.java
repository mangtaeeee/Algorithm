package day17.remind2week;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution43162 {

    boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int count = 0;
        for (int i = 0 ; i < computers.length; i++) {
            if (!visited[i]) {
                count++;
                bfs(i, computers, visited);
            }
        }
        return count;
    }

    private void bfs(int start, int[][] computers, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();

        //시작 컴퓨터 방문처리 + 큐에 넣기
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next = 0 ; next < computers.length; next ++) {
                if (computers[now][next] == 1 && !visited[next]) {
                    visited[next] = true; // 방문 체크
                    queue.offer(next);    // 줄 세우기
                }
            }
        }

    }
}
