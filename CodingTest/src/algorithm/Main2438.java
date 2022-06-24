package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main2438 {

	//첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
	public static void main(String[] args) throws IOException {
		
		BufferedReader sr = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(sr.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i < N; i++) {
			sb.append("*");
			System.out.println(sb);
		}

	}

}
