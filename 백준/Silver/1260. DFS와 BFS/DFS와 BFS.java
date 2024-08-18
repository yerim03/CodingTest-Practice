import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, v;
    public static boolean[] visited;
    public static int[][] graph;
    public static Queue<Integer> q = new LinkedList<>();

    public static void dfs(int v) {
        visited[v] = true;  //현재 정점 방문 처리
        System.out.print(v + " ");

        for (int i = 1; i <= n; i++) {
            if (graph[v][i] == 1 && !visited[i]) {  //방문하지 않은 노드일 경우
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        visited[v] = true;  //현재 정점 방문 처리
        q.offer(v);

        //큐가 빌 때까지 실행
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");

            for (int i = 1; i <= n; i++) {
                if (graph[x][i] == 1 && !visited[i]) {  //방문하지 않은 노드일 경우
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());  //정점의 개수
         m = Integer.parseInt(st.nextToken());  //간선의 개수
         v = Integer.parseInt(st.nextToken());  //탐색 시작 번호

         graph = new int[n+1][n+1];
         for (int i = 0; i < m; i++) {
             StringTokenizer st1 = new StringTokenizer(br.readLine());
             int x = Integer.parseInt(st1.nextToken());
             int y = Integer.parseInt(st1.nextToken());
             graph[x][y] = graph[y][x] = 1; //양방향
         }

         visited = new boolean[n + 1];
         dfs(v);
         System.out.println();
         visited = new boolean[n + 1];
         bfs(v);
    }
}