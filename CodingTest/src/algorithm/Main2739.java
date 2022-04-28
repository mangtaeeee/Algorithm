package algorithm;

import java.util.Scanner;

public class Main2739 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		for (int i=1; i<=9 ; i++) {
			System.out.printf("%d * %d = %d \n",n,i,n * i);
		}
		input.close();

	}

}
