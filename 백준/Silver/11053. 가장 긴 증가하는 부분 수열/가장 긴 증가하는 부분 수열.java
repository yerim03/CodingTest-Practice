import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    //수열의 크기

        int[] array = new int[n + 1];   //수열을 저장하는 배열
        int[] dp = new int[n + 1];  //가장 긴 증가하는 부분수열의 길이를 저장하는 dp테이블

        //수열 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;  //dp 테이블 초기화
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i : dp) {
            result = Math.max(i, result);
        }
        System.out.println(result);
    }
}