package CodingTest.src.algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main10819 {
	 	static int[] nums;
	    static boolean[] visited;
	    static int[] selected;
	    static int n;
	    static int result = Integer.MIN_VALUE;

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        n = Integer.parseInt(br.readLine());
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        nums = new int[n];
	        visited = new boolean[n];
	        selected = new int[n];

			//정수인 N을받아 그수만큼배열에 값을 입력받음
	        for(int i=0; i<n; i++){
	            nums[i] = Integer.parseInt(st.nextToken());
	        }
			//Dfs(깊이 우선탐색으로 탐색 시작)
	        dfs(0);

	        System.out.println(result);
	    }

	    public static void dfs(int count) {
			//만약 count가 정수인 N과 같으면 result 에서 가장 높은값을 result에 담음
	        if(count == n){
				//리턴 받은 sum값을 result에 담음
	            result = Math.max(getResult(), result);
	            return;
	        }

	        for(int i = 0; i < n; i++){
				//배열의 순서대로 방문해 방문하지 않았다면
	            if(!visited[i]){
	                visited[i] = true;
	                selected[count] = nums[i];
	                dfs(count+1);
	                visited[i] = false;
	            }
	        }
	    }

		//식을 계산해줄 메서드
	    public static int getResult(){
	        int sum=0;
	        for(int i = 0; i < n-1; i++){
				//|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]| 식을 여기서 실행
	            sum += Math.abs(selected[i]-selected[i+1]);
	        }
	        return sum;
	    }
}
