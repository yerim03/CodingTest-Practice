package dynamicProgramming.병사배치하기;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    //병사 수

        int[] array = new int[n + 1];   //병사의 전투력
        int[] dp = new int[n + 1];  //전투력을 내림차순으로 배치하는 최대 병사의 수를 계산하는 dp 테이블

        //전투력 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;  //dp 테이블 초기하
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();   //최대 병사의수 구하기
        System.out.println(n - max);
    }
}
