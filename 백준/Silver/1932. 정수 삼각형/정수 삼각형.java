import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    //삼각형의 크기

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int left, right;
                //왼쪽 대각선
                if (j - 1 == 0) {
                    left = 0;
                } else {
                    left = dp[i - 1][j - 1];
                }
                //오른쪽 대각선
                if (j - 1 == n + 1) {
                    right = 0;
                } else {
                    right = dp[i - 1][j];
                }
                dp[i][j] = dp[i][j] + Math.max(left, right);
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dp[n][i]);
        }

        System.out.println(result);
    }
}
