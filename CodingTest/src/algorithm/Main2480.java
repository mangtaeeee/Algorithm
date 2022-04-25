package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2480 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int num3 = Integer.parseInt(st.nextToken());
		int max = num1;// 받은 수중에 최댓값
		
		// 세수가 같으면 
		if (num1 == num2 && num2 == num3) {
			System.out.println(10000 + (1000 * num1));
		// 세수가 다르면
		} else if (num1 != num2 && num2 != num3 && num1 != num3) {
		//최대값 비교후 넣기
			if (max < num2 ) {
				max = num2;
			} 
			if (max < num3) {
				max = num3;
			}
			System.out.println(100 * max);
		//두수만 같을때	
		} else {
			//같은 수 구하기
			if(num1 != num2) {
				System.out.println(1000 + (100 * num3));
			} else if (num1 != num3) {
				System.out.println(1000 + (100 * num2));
			}
		}
		
	}

}
