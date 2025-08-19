import java.io.*;
import java.util.StringTokenizer;

/**
 * S2 11060 점프점프
 */

public class Main {

    static int n;
    static int[] array;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        array = new int[n];
        dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == -1) {
                    continue;
                }
                if (array[j] >= i - j) {    //점프 할 수 있는 경우
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }
        System.out.println(dp[n - 1]);
    }
}