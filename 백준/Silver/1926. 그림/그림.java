import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * S1 1926 그림
 */

public class Main {

    static int[][] array;
    static int n, m;
    static int oneCnt = 0;  //1의 개수
    static int area = 0, cnt = 0, maxArea = 0;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //도화지 세로
        m = Integer.parseInt(st.nextToken());   //도화지 가로

        array = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && array[i][j] == 1) {
                    cnt++;
                    dfs(i, j);
                    maxArea = Math.max(maxArea, area);
                    area = 0;
                }
            }
        }
        System.out.print(cnt + " \n" + maxArea);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        area++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if(!visited[nx][ny] && array[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}