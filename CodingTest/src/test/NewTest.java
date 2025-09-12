package test;

import java.util.Arrays;

public class NewTest {

    public static void main(String[] args) {
        NewTest newTest = new NewTest();
        int[] arr = {5,3,9,13};
        int n = 8;
        boolean result = newTest.solution(arr, n);
        System.out.println("result = " + result);
    }

    public boolean solution(int[] arr, int n) {
        boolean answer = false;
        int start = 0;
        int end = arr.length - 1;
        int sum = 0;

        Arrays.sort(arr);
        while (start < end) {
            sum = arr[start] + arr[end];
            if (sum == n) {
                answer = true;
                break;
            } else if (sum > n) {
                end --;
            }
        }

        return answer;
    }
}
