import java.io.*;

public class Main {

    public static int[] scores = new int[301];
    public static int[] dp = new int[301];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    //계단의 개수

        //계단 점수 입력받기
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max((dp[i - 3] + scores[i - 1]), dp[i - 2]) + scores[i];
        }
        System.out.println(dp[n]);
    }
}