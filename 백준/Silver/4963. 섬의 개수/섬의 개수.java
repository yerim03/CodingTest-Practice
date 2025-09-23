import java.io.*;
import java.util.*;

/**
 * S2 4963 섬의 개수
 */

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int w, h;
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());   //너비
            h = Integer.parseInt(st.nextToken());   //높이

            if (w == 0 && h == 0) {
                break;
            }

            area = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    area[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visited[i][j] && area[i][j] == 1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pair land = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = land.x + dx[i];
                int ny = land.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    continue;
                }

                if (!visited[nx][ny] && area[nx][ny] == 1) {
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}