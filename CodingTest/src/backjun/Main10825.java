package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.
 * 국어 점수가 감소하는 순서로
 * 국어 점수가 같으면 영어 점수가 증가하는 순서로
 * 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
 * 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
 * (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
 * 입력
 * 첫째 줄에 도현이네 반의 학생의 수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 한 줄에 하나씩 각 학생의 이름, 국어, 영어, 수학 점수가 공백으로 구분해 주어진다. 점수는 1보다 크거나 같고, 100보다 작거나 같은 자연수이다. 이름은 알파벳 대소문자로 이루어진 문자열이고, 길이는 10자리를 넘지 않는다.
 *
 * 출력
 * 문제에 나와있는 정렬 기준으로 정렬한 후 첫째 줄부터 N개의 줄에 걸쳐 각 학생의 이름을 출력한다.
 *
 * */

public class Main10825 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] students = new String[N][4];
        for (int i = 0; i < N; i++) {
            students[i] = br.readLine().split(" ");
        }

        Map<String, List<Integer>> map = new HashMap<>();
        for (String[] student : students) {
            String name = student[0];
            int korean = Integer.parseInt(student[1]);
            int english = Integer.parseInt(student[2]);
            int math = Integer.parseInt(student[3]);
            map.put(name, List.of(korean, english, math));
        }

        map.entrySet().stream()
                .sorted((e1, e2) -> {
                    List<Integer> scores1 = e1.getValue();
                    List<Integer> scores2 = e2.getValue();
                    if (!scores1.get(0).equals(scores2.get(0))) {
                        return scores2.getFirst().compareTo(scores1.getFirst()); // 국어 점수 감소
                    } else if (!scores1.get(1).equals(scores2.get(1))) {
                        return scores1.get(1).compareTo(scores2.get(1)); // 영어 점수 증가
                    } else if (!scores1.get(2).equals(scores2.get(2))) {
                        return scores2.get(2).compareTo(scores1.get(2)); // 수학 점수 감소
                    } else {
                        return e1.getKey().compareTo(e2.getKey()); // 이름 사전 순
                    }
                })
                .forEach(entry -> System.out.println(entry.getKey()));


    }
}
