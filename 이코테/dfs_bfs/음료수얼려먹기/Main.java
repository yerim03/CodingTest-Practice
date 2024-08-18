package dfs_bfs.음료수얼려먹기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] graph;
    public static int n, m;

    public static boolean dfs(int x, int y) {
        //주어진 범위를 벗어나면 false 반환
        if (x < 0 || y < 0 || x >= n || y >= m) {
            return false;
        }
        //현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            graph[x][y] = 1;    //방문 처리
            //현재 위치에서 상하좌우로 재귀함수 호출
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        //구멍 뚫린 부분 0, 안뚫린 부분 1
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        //dfs 수행
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j) == true) {
                    result++;
                }
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
