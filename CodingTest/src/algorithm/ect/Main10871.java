package algorithm.ect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main10871 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//값을 입력 받아 공백을 기준으로 토큰으로 나눔
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//첫번째 값으로 반복문을 돌리기위해 담아둠
		int N = Integer.parseInt(st.nextToken());
		//두번째 값은 값을 비교하기위해 담아둠
		int X = Integer.parseInt(st.nextToken());
		//출력을 위해 선언
		StringBuilder sb = new StringBuilder();
		//새로 값을 또 받기위해 순차적 선언
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i ++) {
			//새로값을받은것을 result에 담음 N의 수만큼
			int result = Integer.parseInt(st.nextToken());
			
			//result 값을 비교해 X값보다 적으면 result값 + 공백 넣어서 빌드해줌
			if (result < X) {
				sb.append(result).append(' ');
			}	
		}
		//출력
		System.out.println(sb);
		
		
	}

}
