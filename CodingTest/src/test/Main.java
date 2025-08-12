package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//첫 세개의 값은 항상 정상적인 증가값이 들어오고
//앞에 3개의 수열과 다른 증가값을 가진 인덱스를 반환
//1번 문제
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] n = {2,4,6,200,300,200,300};
        int[] result = main.solution(n);
        System.out.println("result = " + Arrays.toString(result));
    }
    // 비정상 증가 인덱스 반환
    public int[] solution(int[] arr) {
        if (arr == null || arr.length < 3) return new int[0];

        int d = arr[1] - arr[0]; // 공차 (첫 3개가 정상이라고 가정)
        List<Integer> bad = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != d) {
                bad.add(i); // i번째 값이 비정상
            }
        }
        return bad.stream().mapToInt(Integer::intValue).toArray();
    }

}
