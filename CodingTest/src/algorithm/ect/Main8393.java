package algorithm.ect;

import java.util.Scanner;

public class Main8393 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int result = 0 ;
		
		for (int i = 1 ; i <= n; i++) {
			result += i;
		}
		System.out.println(result);
		
		input.close();
	}

}
