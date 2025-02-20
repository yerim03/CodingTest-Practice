package greedy.볼링공고르기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //총 볼링공의 개수
        int m = sc.nextInt();   //공의 최대 무게

        int[] balls = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            balls[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (balls[i] != balls[j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
