import java.io.*;
import java.util.*;

/**
 * G5 12865 평범한 배낭
 */

public class Main {

    static int n, k, maxValue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] W = new int[n + 1];   //물건의 무게
        int[] V = new int[n + 1];   //물건의 가치
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        /*
        * dp[i][j] : 최대 무게가 j인 배낭에 1~i번째 물건까지를 담아서 얻을 수 있는 최대 가치
        * i 물건의 인덱스
        * j 배낭의 최대 무게
        * */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(W[i] <= j) { //i번째 물건의 무게가 현재 최대무게보다 작거나 같을 경우
                    dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - W[i]] + V[i]);
                } else {    //클 경우
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}