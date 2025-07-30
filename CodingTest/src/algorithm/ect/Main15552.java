package algorithm.ect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main15552 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//BufferdReader로 받으면 String으로 받기에 int 타입으로 형변환  해야줘야함
		int n = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			//반복을 돌면서 입력받은 값을 String 값에 담아서
			String 	s = br.readLine();
			//int로 형변환하되 공백마다 끊어서 배열에 넣는 작업
			int a = Integer.parseInt(s.split(" ")[0]); // 공백을 두고 앞에 있는 곳인 0번째 인덱스
			int b = Integer.parseInt(s.split(" ")[1]); // 공백을 두고 뒤에서 1번째 인덱스
			bw.write(a+b+"\n");
		}
		bw.flush();
	}

}
