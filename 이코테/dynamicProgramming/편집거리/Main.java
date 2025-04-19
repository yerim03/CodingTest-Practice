package dynamicProgramming.편집거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[5001][5001];   //최소 편집 거리 계산 dp 테이블

        //최소 편집 거리 계산
        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                //첫번째 행과 열은 공백과 문자가 비교되는 부분으로 따로 처리
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    //문자가 같을 경우, 왼쪽 위 그대로 대입
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
                        //문자가 다를 경우, 1. 삽입(왼쪽), 2.삭제(위쪽), 3. 교체(왼쪽 위) 중 최소값 + 1
                        dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                    }
                }
            }
        }
        System.out.println(dp[str1.length()][str2.length()]);
    }
}
