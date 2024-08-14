package implementation.럭키스트레이트;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();

        int half_length = n.length() / 2;

        int left = 0, right = 0;
        //왼쪽 부분의 자릿수 합
        for (int i = 0; i < half_length; i++) {
            left += n.charAt(i) - '0';
        }
        //오른쪽 부분의 자릿수 합
        for (int i = half_length; i < n.length(); i++) {
            right += n.charAt(i) - '0';
        }

        if (left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}