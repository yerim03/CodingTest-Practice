package dynamicProgramming.효율적인화폐구성;

import java.io.*;
import java.util.*;
/**
 * n가지 종류의 화폐들의 개수를 최소한으로 이용해서 그 가치의 합이 M원이 되도록 하려고 한다.
 * 각 화폐는 몇개라도 사용할 수 있으며, 사용한 화폐의 구성은 같지만 순서만 다른 것은 같은 것으로 구분*/

/**
 * 점화식
 * f(x) = min(f(x), f(x-k) + 1)*/
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //화폐 종류의 수
        int m = Integer.parseInt(st.nextToken());   //원하는 금액

        int[] money = new int[n];   //화폐를 담는 배열
        int[] dp = new int[m + 1];    //최소 화폐 개수를 담는 dp 테이블
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        //dp 테이블 초기화
        dp[0] = 0;
        for (int i = 1; i < m + 1; i++) {
            dp[i] = 10001;
        }

        //1원~m원까지 dp 실행
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - money[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - money[j]] + 1);

                }
            }
        }

        if (dp[m] != 10001) {
            System.out.println(dp[m]);
        } else {
            System.out.println(-1);
        }
    }
}
