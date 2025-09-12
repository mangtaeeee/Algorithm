package test;


import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NewTest3 {


    public static void main(String[] args) {
        NewTest3 newTest3 = new NewTest3();
        String message = "abcbcacbcbacddbcabbbcbdd";
        String result = newTest3.solution(message);
        System.out.println("result = " + result);
    }


    public String solution(String message) {
        if (message == null || message.isEmpty()) return "";

        StringBuilder answer = new StringBuilder();

        // 1) 전체 첫 글자로 전역 분할 → 첫 글자는 전역 소멸이므로 결과에 먼저 추가
        char firstChar = message.charAt(0);
        answer.append(firstChar);

        List<String> segments = Arrays.stream(
                        message.split(Pattern.quote(String.valueOf(firstChar))))
                .filter(part -> !part.isEmpty())
                .collect(Collectors.toList());

        System.out.println("처음 시작 segments = " + segments); // [bcbc, cbcb, cddbc, bbbcbdd]

        // 2) 라운드 반복
        while (!segments.isEmpty()) {
            Set<Character> candidates = new HashSet<>();
            List<String> nextSegments = new ArrayList<>();

            // 각 세그먼트: "해당 세그먼트의 맨 앞 글자"로 split해서 그 글자를 전부 제거하며 '쪼개기'
            for (String segment : segments) {
                if (segment.isEmpty()) continue;

                char headChar = segment.charAt(0);
                candidates.add(headChar);

                // 핵심: replace가 아니라 split으로 '쪼개서' 담는다
                String[] parts = segment.split(Pattern.quote(String.valueOf(headChar)));
                for (String p : parts) {
                    if (!p.isEmpty()) nextSegments.add(p);
                }
            }

            // 디버깅: 원하는 형태(c, c, b, b, ddb, c, dd)로 쪼개졌는지 확인
            System.out.println("쪼갠 뒤 nextSegments = " + nextSegments);

            // 라운드 종료 후, 후보 중 전 세그먼트에서 완전히 사라진 문자만(여럿이면 사전순) 결과에 추가
            List<Character> disappearedChars = candidates.stream()
                    .filter(c -> nextSegments.stream().noneMatch(seg -> seg.indexOf(c) >= 0))
                    .sorted()
                    .collect(Collectors.toList());

            disappearedChars.forEach(answer::append);

            // 다음 라운드로 진행
            segments = nextSegments;
            // 빈 세그먼트는 이미 제외됨
        }

        return answer.toString();
    }

}
