package dynamicProgramming.퇴사;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백트래킹 풀이
 * */
public class Main {

    public static int[] T;
    public static int[] P;
    public static int n = 0, ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    //퇴사 전까지 남은 일수

        T = new int[n];
        P = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int index, int points) {  //index:현재날짜, point: 현재까지 얻은 수익
        //종료조건
        if (index >= n) {
            ans = Math.max(ans, points); //수익이 가장 큰 것으로 변경
            return;
        }

        //현재날짜의 상담업무를 하는 경우
        if (index + T[index] <= n) {
            dfs(index + T[index], points + P[index]);
        }

        //현재날짜 의 상담업무를 하지 않는 경우
        dfs(index + 1, points);
    }
}