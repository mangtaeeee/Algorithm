package test;


import java.util.Arrays;

//드래곤 알은 2틀뒤에 부화한다.
//부화한 드래곤은 매일 알을 낳는다
//부화한 드래곤은 네번의 알을 낳은 후 알을 낳지 않는다.
public class NewTest2 {

    public static void main(String[] args) {
        NewTest2 newTest2 = new NewTest2();
        int n = 6;
        int result = newTest2.solution(n);
        System.out.println("result = " + result);
    }

    public int solution(int n) {

        //알을 낳지 않는 드래곤 수
        int[] eggNotHatched = new int[n];
        //알을 낳을 수 있는 드래곤 수 (부하한 드래곤 수)
        int[] eggHatched = new int[n];
        //드래곤 알 수
        int[] dragonEgg = new int[n];

        for (int i = 0; i < n; i++) {

            //부화한 드래곤 수 = 전날 부화한 드래곤 수 + 2일전 부화하지 않은 드래곤 수
            if (i >= 2) {
                eggHatched[i] = eggHatched[i - 1] + eggNotHatched[i - 2];
                dragonEgg[i] = dragonEgg[i - 1] + eggHatched[i];
            } else {//0,1일전까지는 부화한 드래곤 수가 없음
                eggHatched[i] = 0;
                dragonEgg[i] = 0;
            }
            //부화하지 않은 드래곤 수 = 전날 부화하지 않은 드래곤 수 + 4일전 부화한 드래곤 수
            if (i >= 6) {
                eggNotHatched[i] = eggNotHatched[i - 1] + eggHatched[i - 4];
            } else if (i >= 2) {//2일전까지는 계속 알을 낳지 않은 드래곤 수가 증가
                eggNotHatched[i] = eggNotHatched[i - 1] + 1;
            } else { //0,1일전까지는 부화하지 않은 드래곤 수가 없음
                eggNotHatched[i] = 0;
            }
        }
        return dragonEgg[n - 1] + eggHatched[n - 1] + eggNotHatched[n - 1] + 1;
    }
}
