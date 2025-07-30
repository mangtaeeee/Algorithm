package algorithm.ect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main11022 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int A;
		int B;
        
		StringTokenizer st;
		for (int i = 1; i <= T; i++) {
			//공백 제거 후 끊어주기
			st = new StringTokenizer(br.readLine()," ");
			//다음 토큰을 읽어서 넣음 형변환까지 한번에
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			//출력
			System.out.println("Case #" + i + ": " + A + " + " + B + " = " + (A+B));
		}
		br.close();
	}

}
