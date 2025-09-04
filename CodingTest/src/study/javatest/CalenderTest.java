package study.javatest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalenderTest {
    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();
        for (int i = 0; i < 12; i++) {

            date.set(Calendar.YEAR, 2022);
            date.set(Calendar.MONTH, i);
            date.set(Calendar.WEEK_OF_MONTH, 2);
            date.set(Calendar.DAY_OF_WEEK, 1);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
            System.out.println("simpleDateFormat = " + simpleDateFormat.format(date.getTime()));

        }
    }
}