package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2562 {
	public static void main(String[]args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = new int[9];
		int max = 0;
		int cnt = 0;
		
		for(int i=0; i < a.length; i++) {
			a[i] = Integer.parseInt(br.readLine());
			if(max < a[i]) {
				max = a[i];
				cnt = i+1;
				
			}
		}
		
		System.out.println(max);
		System.out.println(cnt);
	}

}
