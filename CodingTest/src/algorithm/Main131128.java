package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Main131128 {

    public static void main(String[] args) {
        Main131128 main = new Main131128();
        String X = "3403";
        String Y = "13203";
        System.out.println(main.solution(X, Y)); // Output: "330"

    }

    public String solution(String X, String Y) {
        int[] newX = new int[10];
        int[] newY = new int[10];

        for (String x : X.split("")) {
            newX[Integer.parseInt(x)]++;
        }

        for (String y : Y.split("")) {
            newY[Integer.parseInt(y)]++;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int count = Math.min(newX[i], newY[i]);
            if (count > 0) {
                answer.append(String.valueOf(i).repeat(count));
            }
        }
        if (answer.length() == 0) {
            return "-1";
        }
        if (answer.charAt(0) == '0') {
            return "0";
        }


        return answer.toString();
    }
}
