import java.io.*;
import java.util.StringTokenizer;

/**
 * S2 14620 꽃길
 */


public class Main {

    static int n, result = Integer.MAX_VALUE;
    static int[][] array;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        visited = new boolean[n][n];

        //화단 지점당 가격 입력받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        flower(0, 0);
        System.out.println(result);
    }

    public static void flower(int seed, int cost) {
        //종료조건
        if (seed == 3) {
            //최소 대여비용 구하기
            result = Math.min(result, cost);
            return;
        }


        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                //씨앗을 심을 위치와 꽃잎이 필 위치에 아무것도 없는 경우
                if (!visited[i][j] && !visited[i - 1][j] && !visited[i + 1][j] && !visited[i][j - 1] && !visited[i][j + 1]) {
                    visited[i][j] = visited[i - 1][j] = visited[i + 1][j] = visited[i][j - 1] = visited[i][j + 1] = true;
                    int sum = array[i][j] + array[i - 1][j] + array[i + 1][j] + array[i][j - 1] + array[i][j + 1];
                    flower(seed + 1, cost + sum);
                    visited[i][j] = visited[i - 1][j] = visited[i + 1][j] = visited[i][j - 1] = visited[i][j + 1] = false;
                }
            }
        }
    }
}