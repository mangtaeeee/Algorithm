package algorithm;

import java.util.Scanner;

public class Main2884 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt(); //시
		int M = sc.nextInt(); //분
		sc.close();
		
		if(M < 45) { //분이 45 보다 작으면 
			H--; //1시간 감소
			M = 60 - (45 - M); //분 감소 (60분기준)
			if(H < 0) {
				H = 23;
			}
			System.out.println(H + " " + M); 
		} else {
			System.out.println(H + " " + (M - 45));
		}
		

	}

}
