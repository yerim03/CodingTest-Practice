package dynamicProgramming.못생긴수;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] ugly_dp = new int[n]; //못생긴 수를 담는 dp 테이블
        ugly_dp[0] = 1; //1은 못생긴 수

        //각각 2, 3,5배 인덱스
        int index2 = 0, index3 = 0, index5 = 0;
        //처음 곱셈 값 초기화
        //여기서 value2 = ugly_dp[0]*2, value3 = ugly_dp[0]*3, value5 = ugly_dp[0]*5
        int value2 = 2, value3 = 3, value5 = 5;


        for (int i = 1; i < n; i++) {
            ugly_dp[i] = Math.min(value2, Math.min(value3, value5));

            //만약 ugly_dp[i] 값이 각 배수를 곱한 값과 같다면, 해당 곱세결과값 증가
            if (ugly_dp[i] == value2) {
                index2++;
                value2 = ugly_dp[index2] * 2;
            }
            if (ugly_dp[i] == value3) {
                index3++;
                value3 = ugly_dp[index3] * 3;
            }
            if (ugly_dp[i] == value5) {
                index5++;
                value5 = ugly_dp[index5] * 5;
            }
        }

        System.out.println(ugly_dp[n - 1]);
    }
}