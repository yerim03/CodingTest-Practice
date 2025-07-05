import java.io.*;
import java.util.StringTokenizer;

/**
 * G5 3980 선발명단
 */

public class Main {

    static int c;
    static int[][] array = new int[11][11];
    static boolean[] visited = new boolean[11];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        c = Integer.parseInt(br.readLine());

        while (c > 0) {
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0, 0);
            System.out.println(max);
            max = 0;
            c--;
        }
    }

    public static void dfs(int posNumber, int sum) {
        if (posNumber == 11) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            //i번 선수의 능력치가 0이거나 이미 배치된 선수인 경우
            if (array[i][posNumber] == 0 || visited[i]) {
                continue;
            }
            visited[i] = true;  //i번째 선수 방문(배치) 처리
            dfs(posNumber + 1, sum + array[i][posNumber]);  //j번 포지션에 i번 선수 배치
            visited[i] = false;
        }
    }
}