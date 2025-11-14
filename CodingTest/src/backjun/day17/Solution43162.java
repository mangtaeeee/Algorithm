package backjun.day17;

public class Solution43162 {

    static boolean[] visited;

    public static void main(String[] args) {
        Solution43162 solution43162 = new Solution43162();
        int[][] ar = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        for (int i = 0; i < n; i ++) {
            if (!visited[i]) {
                dfs(computers, i , visited);
                answer++;
            }
        }
        return answer;
    }

    static void dfs(int[][] computers, int node, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < computers.length; i++) {
            if (i != node && computers[node][i] == 1 && !visited[i] ) {
                dfs(computers, i, visited);
            }
        }
    }
}
