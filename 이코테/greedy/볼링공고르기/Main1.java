package greedy.볼링공고르기;

import java.util.Scanner;

/*
 * 무게마다 볼링공이 몇개 있는지 계산한 후에,
 * 무게가 낮은 볼링공 -> 무게가 높은 볼링공 순으로
 * */
public class Main1 {

    public static int n, m;
    public static int[] balls = new int[11];    //볼링공의 무게를 담을 수 있는 배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            balls[weight]++;
        }

        int count = 0;

        for (int i = 1; i <= m; i++) {
            n -= balls[i];
            count += balls[i] * n;
        }

        System.out.println(count);
    }
}
