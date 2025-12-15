package day17.remind1_5;

public class Solution43165 {

    static int answer;

    public static void main(String[] args) {
        Solution43165 solution43165 = new Solution43165();
        int solution = solution43165.solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int index, int sum) {
        if (numbers.length == index) {
            if (sum == target) {
                answer ++;
            }
            return;
        }
        dfs(numbers, target, index + 1, sum + numbers[index]);
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }


}
