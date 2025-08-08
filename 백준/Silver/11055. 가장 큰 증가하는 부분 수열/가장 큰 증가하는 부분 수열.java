import java.io.*;
import java.util.StringTokenizer;

/**
 * S2 11055 가장 큰 증가하는 부분 수열
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = array[i];
        }

        for (int i = 1; i < n; i++) {   //부분수열의 마지막 숫자가 array[i]
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + array[i]);
                }
            }
        }

        int result = 0;
        for (int i : dp) {
            result = Math.max(result, i);
        }
        System.out.println(result);
    }
}