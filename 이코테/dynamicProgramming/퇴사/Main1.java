package dynamicProgramming.퇴사;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 다이나믹 프로그래밍 풀이
 * */
public class Main1 {
    static int[] T;
    static int[] P;
    static int n;
    static int[] dp = new int[16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    //퇴사 전까지 남은 일수

        T = new int[n];
        P = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i + T[i] <= n) {    //상담 가능한 경우
                //상담 가능한 경우라도 상담을 할수도, 하지 않을 수도 있다.
                //1. i번째 날의 상담을 할 경우: P[i] + dp[i + T[i]]
                //2. i번째 날의 상맏을 하지 않을 경우 : dp[i + 1]
                dp[i] = Math.max(P[i] + dp[i + T[i]], dp[i + 1]);

            }
            else {  //상담 불가능한 경우
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[0]);
    }
}