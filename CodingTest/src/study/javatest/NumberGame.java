package study.javatest;


import java.util.InputMismatchException;
import java.util.Scanner;

/*
 1~100 사이의 숫자를 맞추는 게임을 해본다.
 입력은 아래 코드를 활용해 받으면 되고 실행시 아래 멘트와 같이 출력하면 된다.
 단 숫자가 아닌 영문자를 넣을 시 예외처리를해서 숫자가 아닌값을 받았을때는 다시 입력 받도록 한다.
 input = new Scanner(System.in).nextInt();
 */
public class NumberGame {
    public static void main(String[]args){

        int number = (int) (Math.random() * 100) + 1;

        int i = 0;
        while (true) {

            try{
                System.out.print("1과 100사이의 값을 입력해주세요 : ");
                Scanner input = new Scanner(System.in);
                int n = input.nextInt();
                if (n < number) {
                    System.out.println("더 큰 수를 입력해 주세요");
                }
                if (n > number) {
                    System.out.println("더 작은 수를 입력해주세요");
                }
                if (n == number) {
                    System.out.println("맞췄습니다. 시도횟수는" + (i + 1) + "입니다.");
                    break;
                }

                i++;
            } catch (InputMismatchException e) {
                System.out.println("유요하지 않은값입니다. 다시 값을 입력해 주세요...");
                i++;
                continue;
            }

        }
    }

}
