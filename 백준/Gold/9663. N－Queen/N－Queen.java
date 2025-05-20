import java.io.*;

/**
 * n * n의 체스판 위에 n개의 퀸을 놓아야 한다.
 * 퀸은 수평, 수직, 대각선으로 공격을 할 수 있다.
 * 결국 퀸은 각 행에 1개씩 반드시 들어가야 한다고 볼 수 있다.
 * */
public class Main {

    public static int n, result = 0;
    public static int[] v1, v2, v3; //v1: 위쪽, v2: 오른쪽 위 대각선,  v3: 왼쪽 위 대각선
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        v1 = new int[n];
        v2 = new int[n * 2];
        v3 = new int[n * 2];
        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int i) {
        if (i == n) { 
            result++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (v1[j] == 0 && v2[i + j] == 0 && v3[(i - j) + n - 1] == 0) {

                v1[j] = v2[i + j] = v3[(i - j) + n - 1] = 1;
                dfs(i + 1);
                //재귀가 끝나면 원래대로
                v1[j] = v2[i + j] = v3[(i - j) + n - 1] = 0;
            }
        }
    }
}