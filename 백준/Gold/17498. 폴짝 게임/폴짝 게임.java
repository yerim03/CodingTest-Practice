import java.io.*;
import java.util.*;

/**
 * G5 17498 폴짝게임
 * */

public class Main {

    static int n, m, d, max_score = Integer.MIN_VALUE;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //행의 개수
        m = Integer.parseInt(st.nextToken());   //열의 개수
        d = Integer.parseInt(st.nextToken());   //최대 점프 거리

        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            //dp배열 초기화
            if(i == 0) {
                Arrays.fill(dp[i], 0);
            } else {
                Arrays.fill(dp[i], Integer.MIN_VALUE);
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                for(int x = i + 1; x <=i + d; x++) {
                    for(int y = j - d; y <= j + d; y++) {
                        if(x >= n || y < 0 || y >= m) continue;
                        if (Math.abs(x - i) + Math.abs(y - j) <= d) {
                            dp[x][y] = Math.max(dp[x][y], dp[i][j] + map[x][y] * map[i][j]);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            max_score = Math.max(dp[n - 1][i], max_score);
        }

        System.out.println(max_score);
    }
}