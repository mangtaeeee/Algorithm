package programmers.LV1;

import java.util.Arrays;

public class NotCompletePlayer {
	
	public String solution(String[] participant, String[] completion) {
		//두개의 배열을 정렬 후
		Arrays.sort(participant);
		Arrays.sort(completion);
		//return을 위한 변수 선언 또한 마지막에 선수가 다른값일수 있으므로 선언
		int i = 0;
		//반복문을 통한 비교 두배열이 다를때까지 찾는다.
		for(i = 0 ; i < completion.length; i++) {
			if(!participant[i].equals(completion[i])) {
				break;
			}
				
		}
		return participant[i];
	}
	public static void main(String[]args) {
		String[] part = {"leo", "kiki", "eden"};
		String[] comp = {"eden", "kiki"};
		NotCompletePlayer sol = new NotCompletePlayer();
		System.out.println(sol.solution(part, comp));
		
	}

}
