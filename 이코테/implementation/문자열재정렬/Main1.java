package implementation.문자열재정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
* 입력한 문자열에서 알파벳, 숫자를 따로 구분해서 정렬, 계산한 후 출력
* ArrayList 사용
* */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int num = 0;
        ArrayList<Character> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            //알파벳일 경우
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                result.add(str.charAt(i));
            } else {
                //숫자일 경우
                num += str.charAt(i) - '0';
            }
        }

        //알파벳 오름차순 정렬
        Collections.sort(result);

        //알파벳 출력
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }
        //숫자 출력 - 숫자가 하나도 없을 수 있기 때문에 존재하는지 확인한 후 출력
        if (num != 0) {
            System.out.print(num);
        }
    }
}
