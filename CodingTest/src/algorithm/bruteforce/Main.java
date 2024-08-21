package algorithm.bruteforce;

public class Main {

    class Solution {
        public int solution(int[][] flowers) {
            int [][] result;
            int answer = 0;

            for (int i=0;i < flowers.length; i++){
                result = new int[i][];
                for(int j=0; j < flowers.length; j++){
                    result[i][j] = flowers[i][j];
                }
            }

            for (int i=0; i < flowers.length; i++){

            }

            return answer;
        }
    }
}
