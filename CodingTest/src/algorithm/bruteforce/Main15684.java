package algorithm.bruteforce;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main15684 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer st;

    static int C,M,R;
    static int[][] ladder;
    public static void main(String[]args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        st = new StringTokenizer(input.readLine());
        C  = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());
        R  = Integer.parseInt(st.nextToken());

        ladder = new int[R+1][C+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = 1;   //가로선의 시작점
            ladder[a][b+1] = -1;//가로선의 맞은편
        } // 입력 처리 완료

        // 0~3개까지 가로선을 추가해보면서 게임이 끝나는지 살펴보자.
        for(int i=0; i<=3; i++){
            //i 개수만큼 가로선 추가해보기
            boolean result = makeLine(1, 1, i, i);
            if(result){
                return;
            }
        }

        //아직 안끝낫다면?
        System.out.println(-1);

    }

    /**
     * lineCnt 만큼의 선을 그어가보면서 선택이 완료되면 check 호출로 결과 확인
     * @param sr 출발점 row
     * @param sc 출발점 col
     * @param toChoose 골라야할 개수
     * @param lineCnt 고르기로 한 개수
     */
    private static boolean makeLine(int sr, int sc, int toChoose, int lineCnt){
        if(toChoose==0){
            if (check()) {
                System.out.println(lineCnt);
                //정답을 알았으니 더이상 재귀 x
                return true;
            }
            return false;
        }

        for(int r=sr; r<=R; r++){
            for(int c=sc; c<C; c++){
                if(ladder[r][c] ==0 && ladder[r][c+1]==0){
                    ladder[r][c] = 1;
                    ladder[r][c+1] = -1;
                    //가자치기 조건
                    if(makeLine(r,c+2, toChoose-1, lineCnt)){
                        return true;
                    }

                    ladder[r][c]=0;
                    ladder[r][c+1]=0;
                }
            }// row 하나 체크 완료
            // row가 변경되면 col은 1부터 시작해야된다
            sc=1;

        }
        return false;
    }

    private static boolean check(){
        for(int i=1; i<=C; i++){
            int nc = i; //이동하고 있는 컬럼의 좌표
            for(int j=1; j<=R; j++){
                //1이면 오른쪽으로, -1 이면 왼쪽으로
                if(ladder[j][nc] == 1){
                    nc++;
                }else if(ladder[j][nc]==-1){
                    nc--;
                }
            } // 해당 c에대한 체크 완료
            if(i != nc){
                return false;
            }
        }
        return true;
    }

    private static String src = "5 6 6\n"
                                + "1 1\n"
                                + "3 1\n"
                                + "5 2\n"
                                + "4 3\n"
                                + "2 3\n"
                                + "1 4";
}
