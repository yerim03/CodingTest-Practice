import java.io.*;
import java.util.*;

/**
 * S2 11724 연결 요소의 개수
 */

public class Main {

    static int n, m, cnt = 0;
    static int[][] array = new int[1001][1001];
    static boolean[] visited = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());    //정점의 개수
        m = Integer.parseInt(st.nextToken());    //간선의 개수

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            array[u][v] = array[v][u] = 1;
        }

        for (int u = 1; u <= n; u++) {
            if (!visited[u]) {
                dfs(u);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int u) {
        if(visited[u]) return;

        for (int i = 1; i <= n; i++) {
            if (array[u][i] == 1) {
                visited[u] = true;
                dfs(i);
            }
        }
    }
}