package greedy.큰수의법칙;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
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

        /*가장 큰수 k번 + 두번째로 큰 수 1번을 계속 반복해서 총 m번
        (가장 큰수 k번 + 두번째로 큰 수)가 계속 반복되기 때문에 하나의 수열로 보면,
        수열의 길이는 (k+1)
        m / (k + 1)이 수열이 반복되는 횟수
         */

        //가장 큰 수가 더해지는 횟수 계산
        int count = m / (k + 1) * k;
        count += m % (k + 1);

        int result = 0;
        result += count * first;    //가장 큰 수 더하기
        result += (m - count) * second;    //두번째로 큰 수 더하기
        System.out.println(result);
    }
}
