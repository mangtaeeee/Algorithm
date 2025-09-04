package programmers.LV1;

import java.util.StringTokenizer;

public class Digit {
	 public int solution(int n) {
			String num = Integer.toString(n);
			StringTokenizer st = new StringTokenizer(num);
			
			
			int result=0, number=0;
	        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
	  
			while(st.hasMoreTokens()) {
				
				result = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(result);
	        return result;
	    }

}
