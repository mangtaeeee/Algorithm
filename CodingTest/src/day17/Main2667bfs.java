package day17;

import java.util.*;

public class Main2667bfs {

    //아파트 단지
    static int[][] danji;
    //방문 여부
    static boolean[][] visited;
    // 상하좌우 이동 방향
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int N ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();           // 단지 수 입력
        sc.nextLine();              // 버퍼 제거
        danji = new int[N][N];      // 아파트 단지 입력
        visited = new boolean[N][N];// 방문 여부 배열 (단지랑 배열 수 같게)

        // 001000 값 담는 반복문
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                danji[i][j] = line.charAt(j) - '0';
            }
        }

        //결과를 받는 배열 단지별 속하는 집의 수
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N; j++) {
                if (danji[i][j] == 1 && !visited[i][j]) {
                    result.add(bfs(i, j));
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }

    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x , y});
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int cx = now[0];
            int cy = now[1];

            for (int dir = 0; dir < 4 ; dir ++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (danji[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        count ++;
                    }
                }
            }
        }
        return count;
    }
}
