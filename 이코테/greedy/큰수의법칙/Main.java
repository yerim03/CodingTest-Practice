package greedy.큰수의법칙;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        //n개의 자연수 입력
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        int first = numbers[n - 1];     //가장 큰 수
        int second = numbers[n - 2];    //두 번째로 큰수

        int result = 0;
        //가장 큰수 k번 + 두번째로 큰 수 1번을 계속 반복해서 총 m번
        while (m > 0) {
            for (int i = 1; i <= k; i++) {
                result += first;
                m--;
            }
            result += second;
            m--;
        }
        System.out.println(result);
    }
}
