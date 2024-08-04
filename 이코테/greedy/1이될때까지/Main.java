package greedy;

import java.util.Scanner;

/*
* 어떠한 수 N이 1이 될 때까지 아래 두 과정 중 하나를 반복적으로 수행한다.
* 1. N에서 1을 뺀다.
* 2. N을 K로 나눈다.(N이 K로 나누어 떨어질 때만 사용가능)
* 이 때, 최소 수행횟수를 구한다.
* */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int cnt = 0;
        while (n > 1) {
            if (n % k == 0) {
                n /= k;
            } else {
                n -= 1;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
