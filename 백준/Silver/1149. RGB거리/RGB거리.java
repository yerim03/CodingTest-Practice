import java.io.*;
import java.util.*;

/**
 * S1 1149 rgb 거리
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i][j] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                } else if (j == 1) {
                    dp[i][j] = dp[i][j] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                } else if (j == 2) {
                    dp[i][j] = dp[i][j] + Math.min(dp[i - 1][0], dp[i - 1][1]);
                }
            }
        }
        int minCost = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(minCost);
    }
}