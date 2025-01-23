package dfs_bfs.미로탈출;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Pair{
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, m;
    public static int graph[][];
    public static Queue<Pair> q = new LinkedList<>();

    //상, 하, 좌, 우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        q.offer(new Pair(x, y));    //탐색 시작 노드를 큐에 삽입


        //큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            Pair pair = q.poll();   //큐에서 현재 탐색 노드를 꺼냄
            x = pair.x;
            y = pair.y;

            //상, 하, 좌, 우로 탐색해서 이동할 수 있는 부분이 있는지 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //미로 공간을 벗어날 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Pair(nx, ny));
                }
            }
        }
        return graph[n-1][m-1];
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        graph = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }
}
