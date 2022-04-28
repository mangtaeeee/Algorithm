package algorithm;

import java.util.Scanner;

public class Main10950 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		int n = input.nextInt();
		int x = input.nextInt();
		int y = input.nextInt();
		
		for(int i=0 ; i < n; i ++ ) {
			System.out.println(x+y);
		}
		input.close();
	}

}
