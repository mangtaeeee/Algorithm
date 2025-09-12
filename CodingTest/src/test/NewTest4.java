package test;

import java.util.*;
import java.util.function.Consumer;

public class NewTest4 {

        public String solution(String[] prj, int n, int k) {
            // 1) 모든 개발자 추출 후 알파벳순 정렬
            TreeSet<Character> developerSet = new TreeSet<>();
            for (String project : prj) {
                for (char dev : project.toCharArray()) {
                    developerSet.add(dev);
                }
            }
            List<Character> developers = new ArrayList<>(developerSet);
            int devCount = developers.size();

            // 개발자 문자 -> 인덱스 매핑
            Map<Character, Integer> devIndex = new HashMap<>();
            for (int i = 0; i < devCount; i++) {
                devIndex.put(developers.get(i), i);
            }

            // 2) 각 개발자의 리뷰 후보 집합(같은 프로젝트에 속한 다른 개발자)
            List<Set<Integer>> reviewerCandidates = new ArrayList<>();
            for (int i = 0; i < devCount; i++) reviewerCandidates.add(new HashSet<>());
            for (String project : prj) {
                List<Integer> members = new ArrayList<>();
                for (char dev : project.toCharArray()) members.add(devIndex.get(dev));
                for (int a : members) {
                    for (int b : members) {
                        if (a != b) reviewerCandidates.get(a).add(b);
                    }
                }
            }

            // 3) 각 개발자별로 가능한 리뷰어 조합(크기 n) 준비, 사전순 정렬
            List<List<Choice>> allChoices = new ArrayList<>();
            for (int i = 0; i < devCount; i++) {
                List<Choice> options = new ArrayList<>();
                List<Integer> candidates = new ArrayList<>(reviewerCandidates.get(i));
                candidates.sort(Comparator.comparingInt(x -> developers.get(x)));
                generateCombinations(candidates, n, combo -> {
                    StringBuilder sb = new StringBuilder();
                    for (int idx : combo) sb.append(developers.get(idx));
                    options.add(new Choice(sb.toString(), new ArrayList<>(combo)));
                });
                options.sort(Comparator.comparing(c -> c.reviewerStr));
                allChoices.add(options);
            }

            // 4) DFS 탐색
            int[] reviewerCapacity = new int[devCount];
            Arrays.fill(reviewerCapacity, k);
            StringBuilder current = new StringBuilder();
            String[] bestString = new String[1];

            search(0, developers, allChoices, reviewerCapacity, current, bestString);

            return bestString[0] == null ? "" : bestString[0];
        }

        // 리뷰어 조합 하나
        private static class Choice {
            String reviewerStr;
            List<Integer> reviewerIdx;
            Choice(String reviewerStr, List<Integer> reviewerIdx) {
                this.reviewerStr = reviewerStr;
                this.reviewerIdx = reviewerIdx;
            }
        }

        // 후보자 중 n명을 뽑는 조합 생성
        private static void generateCombinations(List<Integer> candidates, int r, Consumer<List<Integer>> consumer) {
            backtrackCombination(candidates, r, 0, new ArrayList<>(), consumer);
        }

        private static void backtrackCombination(List<Integer> candidates, int r, int start,
                                                 List<Integer> current, Consumer<List<Integer>> consumer) {
            if (current.size() == r) {
                consumer.accept(current);
                return;
            }
            for (int i = start; i < candidates.size(); i++) {
                current.add(candidates.get(i));
                backtrackCombination(candidates, r, i + 1, current, consumer);
                current.remove(current.size() - 1);
            }
        }

        // DFS로 전체 문자열 탐색 (사전순 최소 선택)
        private static void search(int idx, List<Character> developers, List<List<Choice>> allChoices,
                                   int[] reviewerCapacity, StringBuilder current, String[] best) {
            int totalDevs = developers.size();
            if (idx == totalDevs) {
                String result = current.toString();
                if (best[0] == null || result.compareTo(best[0]) < 0) {
                    best[0] = result;
                }
                return;
            }

            for (Choice choice : allChoices.get(idx)) {
                // 수용량 확인
                boolean canUse = true;
                for (int r : choice.reviewerIdx) {
                    if (reviewerCapacity[r] == 0) { canUse = false; break; }
                }
                if (!canUse) continue;

                // 현재 문자열에 이어붙이기
                int prevLen = current.length();
                current.append(choice.reviewerStr);

                // 접두사 가지치기
                boolean promising = true;
                if (best[0] != null) {
                    int cmpLen = Math.min(best[0].length(), current.length());
                    if (current.substring(0, cmpLen).compareTo(best[0].substring(0, cmpLen)) > 0) {
                        promising = false;
                    }
                }

                if (promising) {
                    for (int r : choice.reviewerIdx) reviewerCapacity[r]--;
                    search(idx + 1, developers, allChoices, reviewerCapacity, current, best);
                    for (int r : choice.reviewerIdx) reviewerCapacity[r]++;
                }
                current.setLength(prevLen);
            }
        }


    // ---- 실행 예시 ----
    public static void main(String[] args) {
        NewTest4 s = new NewTest4();
        String[] prj = {"OR", "QO", "R", "OQ", "OR"};
        String result = s.solution(prj, 1, 2);
        System.out.println(result); // 기대: BCADADBCACBXDE
    }
}
