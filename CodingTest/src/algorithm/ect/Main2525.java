package algorithm.ect;

import java.io.*;
import java.util.*;


public class Main2525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(br.readLine());
		a += (b+c) / 60;
		if(a >= 24) {
			a -= 24;
		}
		b = (b+c) % 60;
		System.out.print(a + " " + b);
		

	}

}

        