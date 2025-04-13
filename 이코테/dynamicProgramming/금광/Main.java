package dynamicProgramming.금광;

import java.io.*;
import java.util.*;

/**
 *
 * 점화식
 * dp[i][j] = dp[i][j] + max(dp[i-1][j-1], dp[i][j-1], dp[i+1][j-1])
 * */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] array = new int[n][m];
            int[][] dp = new int[n][m];

            //금광 정보 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //dp 테이블 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = array[i][j];
                }
            }

            //dp 시작
            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    int left_up, left_down, left;
                    //왼쪽 위 -> dp[i-1][j-1]
                    if (i == 0) {
                        left_up = 0;
                    } else {
                        left_up = dp[i - 1][j - 1];
                    }

                    //왼쪽 -> dp[i][j-1]
                    left = dp[i][j - 1];

                    //왼쪽 아래 -> dp[i+1][j-1]
                    if (i == n - 1) {
                        left_down = 0;
                    } else {
                        left_down = dp[i + 1][j - 1];
                    }
                    dp[i][j] = dp[i][j] + Math.max(left_up, Math.max(left, left_down));
                }
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                result = Math.max(result, dp[i][m - 1]);
            }
            System.out.println(result);
        }
    }
}
