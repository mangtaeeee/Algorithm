package algorithm.ect;

import java.util.ArrayList;
import java.util.Scanner;

public class Main10950 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		int n = input.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0 ; i < n; i ++ ) {
			int a = input.nextInt();
			int b = input.nextInt();
			list.add(a+b);
		}
 		for(int i : list) {
 			System.out.println(i);
		}
		input.close();
	}

}
