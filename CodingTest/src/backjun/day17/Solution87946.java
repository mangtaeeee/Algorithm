package backjun.day17;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution87946 {

    static boolean[] visited; //방문 여부
    static int max = 0;       //최대 탐험 가능 던전 수


    public static void main(String[] args) {
        Solution87946 solution87946 = new Solution87946();
        int[][] ar = new int[][]{{80,20},{50,40},{30,10}};
        int solution = solution87946.solution(80, ar);
        System.out.println("solution = " + solution);
    }

    public int solution(int k , int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return max;
    }

    static void dfs (int[][] dungeons, int k, int count) {
        max = Math.max(max, count);

        for (int i = 0; i < dungeons.length; i ++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;                                      //방문처리
                dfs(dungeons, k - dungeons[i][1], count + 1);  //재귀호출을 통한 던전 철;ㅣ
                visited[i] = false;                                     //백트래킹
            }
        }
    }

}
