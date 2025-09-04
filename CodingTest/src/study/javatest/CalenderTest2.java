package study.javatest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CalenderTest2 {

    public static void main(String[] args) {
        String datePattern = "yyyy/MM/dd";
        String result = "E요일 입니다.";

        DateFormat sdf  = new SimpleDateFormat(datePattern);
        DateFormat sdf2 = new SimpleDateFormat(result);

        Scanner n = new Scanner(System.in);

        Date date ;

        do{
            try {
                System.out.print("날짜를 입력해 주세요 :");
                date = sdf.parse(n.nextLine());
                break;
            }
            catch(Exception e){
                System.out.println("날짜를 다시 입력해 주세요");
            }
        }
        while(true);

        System.out.println(sdf2.format(date));
    }
}
