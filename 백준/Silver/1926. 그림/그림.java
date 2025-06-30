import java.io.*;
import java.util.StringTokenizer;

/**
 * S1 1926 그림
 */

public class Main {

    static int[][] array;
    static int n, m;
    static int oneCnt = 0;  //1의 개수
    static int area, cnt = 0, maxArea = Integer.MIN_VALUE;
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
                if (array[i][j] == 1) { //1의 개수 세기
                    oneCnt++;
                }
            }
        }

        //그림이 하나도 없는 경우
        if (oneCnt == 0) {
            System.out.print(0 + " \n" + 0);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                area = 0;
                if(dfs(i, j)) {
                    cnt++;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        System.out.print(cnt + " \n" + maxArea);
    }


    public static boolean dfs(int x, int y) {

        if (x < 0 || y < 0 || x >= n || y >= m) {
            return false;
        }
        if(!visited[x][y] && array[x][y] == 1) {
            visited[x][y] = true;
            area++;

            for (int i = 0; i < 4; i++) {
                dfs(x + dx[i], y + dy[i]);
            }
            return true;
        }
        return false;
    }
}