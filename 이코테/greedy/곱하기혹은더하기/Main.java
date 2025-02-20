package greedy.곱하기혹은더하기;

/*
* '*', '+' 연산자로 만들어질수 있는 가장 큰 수 구하기
* */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        long result = (int) str.charAt(0) - '0';
        for (int i = 1; i < str.length(); i++) {
            int a = (int) str.charAt(i) - '0';
            if (result <= 1 || a <= 1) {
                result += a;
            } else {
                result *= a;
            }
        }
        System.out.println(result);
    }
}
