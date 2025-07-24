package algorithm;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main181866 {

    public String[] solution(String myString) {
        return Stream.of(myString.split("x"))
                .filter(s -> !s.isEmpty())
                .sorted()
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        Main181866 main = new Main181866();
        String myString = "axbxcxd";
        String[] result = main.solution(myString);
        System.out.println(Arrays.toString(result)); // Output: [a, b, c, d]
    }
}
