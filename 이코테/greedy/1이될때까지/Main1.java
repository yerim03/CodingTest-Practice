package greedy;

import java.util.Scanner;

//방법2. n이 k의 배수가 되도록 효율적으로 한번에 빼는 방식
/*
반복문이 1번 수행될 때마다 n이 k로 나누어지는 연산이 수행된다.
따라서 n이 기하급수적으로 줄어들기 때문에 시간복잡도가 줄어든다
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int cnt = 0;
        while (true) {
            //N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (n / k) * k;   //target은 k로 나누어 떨어지는 수
            cnt += n - target;  //1을 빼는 연산 횟수 더하기
            n = target;

            //N이 K보다 작을 때(더이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) {
                break;
            }
            cnt += 1;   //n을 k로 나누는 연산 횟수 더하기
            n /= k;
        }

        cnt += (n - 1); //break로 탈출했을 때의 n에 대해서 1씩 빼기
        System.out.println(cnt);
    }
}
