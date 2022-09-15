package algorithm;

import java.io.*;
import java.util.HashSet;


public class Main3052 {
	public static void main(String[]args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> n = new HashSet<Integer>();
		
		for(int i=0; i < 10 ; i++) {
			n.add(Integer.parseInt(bf.readLine()) % 42);
		}
		System.out.println(n.size());
	}

}
