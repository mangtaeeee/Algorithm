package programmers.LV1;

public class EvenOdd {
	public String solution(int num) {
		String answer = "";
		if (num %2 == 0) {
			answer = "Even";
			return answer;
		} else if(num %1 == 0) {
			answer = "Odd";
			return answer;
		}
		
		
        return answer;
	}

}
