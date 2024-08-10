import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int count_0 = 0;    //전부 0으로 바꾸는 경우
        int count_1 = 0;    //전부 1로 바꾸는 경우

        //첫번째 숫자를 바꾸는 경우에 대해서 처리
        if (str.charAt(0) == '1') {
            count_0++;
        } else {
            count_1++;
        }

        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == '1') { //1->0으로 바꾸는 경우
                    count_0++;
                } else {                        //0->1로 바뀌는 경우
                    count_1++;
                }
            }
        }

        System.out.println(Math.min(count_0, count_1));
    }
}
