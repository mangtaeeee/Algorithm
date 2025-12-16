package day17.remind2week;

public class Solution43165 {
    static int answer = 0;

    public static void main(String[] args) {
        day17.Solution43165 solution43165 = new day17.Solution43165();
        int solution = solution43165.solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int index, int sum) {
        if (numbers.length == index) {
            if (target == sum) {
                answer++;
            }
            return;
        }

        dfs (numbers, target, index + 1, sum + numbers[index]);
        dfs (numbers, target, index + 1, sum - numbers[index]);

    }
}
