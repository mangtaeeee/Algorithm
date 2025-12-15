package day17;

public class Solution43162 {

    //방문여부
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int count = 0;

        for (int i = 0 ; i < computers.length ; i ++) {
            if (!visited[i]) {
                count ++;
                dfs(i, computers);
            }
        }
        return count;
    }

    public void dfs(int nowNumber, int[][] computers) {
        visited[nowNumber] = true;

        for (int next = 0 ; next < computers.length; next ++) {
            if (computers[nowNumber][next] == 1 && !visited[next]) {
                dfs(next, computers);
            }
        }
    }
}
