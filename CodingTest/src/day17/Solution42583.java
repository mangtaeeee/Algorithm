package day17;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution42583 {

    //bridge_length : 다리에올라갈수있는 트럭 수,
    // weight: 다리가 견딜수 있는 무게의 수,
    //truck_weights : 대기하고있는 트럭의 무게
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Deque<Integer> bridge = new ArrayDeque<>(); // 다리
        int time = 0;        // 경과 시간
        int totalWeight = 0; // 다리 위 현재 무게

        for (int truck : truck_weights) {

            // 이 트럭을 다리 위로 올리기 전까지 계속 진행
            while (true) {

                // 다리가 꽉 차 있는 경우 => 앞 트럭 내보내기
                if (bridge.size() == bridge_length) {
                    totalWeight -= bridge.poll();
                }

                // 새로운 트럭을 올릴 수 있는 경우
                if (totalWeight + truck <= weight) {
                    bridge.add(truck);
                    totalWeight += truck;
                    time++;  // 트럭이 올라가는 데 1초
                    break;   // 다음 트럭으로 넘어가기
                }
                // 올릴 수 없는 경우: 0 넣고 시간만 소모
                else {
                    bridge.add(0);
                    time++;
                }
            }
        }

        // 모든 트럭이 큐에 들어갔으면, 마지막 트럭이 다 건널 때까지 남은 다리 길이만큼 더 더한다.
        return time + bridge_length;
    }

}
