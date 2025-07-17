package algorithm;

import java.util.Arrays;

public class Main120911 {

    public static void main(String[] args) {
        Main120911 main = new Main120911();
        String result = main.solution("BBACder");
        System.out.println(result);  // Output: abcdefghijklmnopqrstuvwxyz
    }

    public String solution(String my_string) {

        my_string = my_string.toLowerCase();

        char[] chars = my_string.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
                sb.append(c);
        }
        return sb.toString();
    }
}
