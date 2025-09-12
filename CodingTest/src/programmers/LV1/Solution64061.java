package programmers.LV1;

public class Solution64061 {

    public int solution(int[][] board, int[] moves) {


        for (int i=0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        Solution64061 sol = new Solution64061();
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = {1,5,3,5,1,2,1,4};
        int result = sol.solution(board,moves);
    }
}
