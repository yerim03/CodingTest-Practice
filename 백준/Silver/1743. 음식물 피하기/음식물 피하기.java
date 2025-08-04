import java.io.*;
import java.util.StringTokenizer;

/**
 * S1 1743 음식물 피하기
 */

public class Main {

    static int n, m, k;
    static int result = 0, size = 0;
    static int[][] trash;
    static boolean[][] visited = new boolean[100][100];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());   //음식물 쓰레기의 개수

        trash = new int[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            trash[r - 1][c - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && trash[i][j] == 1) {
                    result = Math.max(result, dfs(i, j));
                    size = 0;
                }
            }
        }
        System.out.println(result);
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        size++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (trash[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
        return size;
    }
}