package programmers.LV2;

import java.util.StringTokenizer;

public class MaxOrMin {
	 public String solution(String s) {

		 StringTokenizer st = new StringTokenizer(s , " ");
		 int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, n;
		 while(st.hasMoreTokens()) {
			 n = Integer.parseInt(st.nextToken());
			 if (max < n) {
				 max = n;
			 }
			 if (min > n) {
				 min = n;
			 }
		 } 
		 return min + " " + max;
	 }
	 
	 public static void main(String[]args) {
		 String str = "1 2 3 4";
		 MaxOrMin mo = new MaxOrMin();
		 System.out.println("최댓값과 최솟값은? = "+ mo.solution(str));
	 }

}
