package algorithm.ect;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main120850 {

    public static void main(String[]args) {
        String my_string = "hi12392";
        int[] result = solution(my_string);
        System.out.println(Arrays.toString(result)); // Output: [1, 2, 2, 3, 9]
    }


    public static int[] solution(String my_string) {

        String num = my_string.replaceAll("[^0-9]", "");

        return Stream.of(num.split(""))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }

}
