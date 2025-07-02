import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * G5 7576 토마토
 */

class Pair {
    int x;
    int y;
    int time;   //토마토가 익는데 걸리는  시간

    public Pair(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {

    static int m, n;
    static int result = 0;
    static int[][] box;
    static Queue<Pair> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());   //가로
        n = Integer.parseInt(st.nextToken());   //세로

        box = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {   //익은 토마토의 위치를 큐에 삽입
                    q.offer(new Pair(i, j, 0));
                }
            }
        }
        bfs();

        for (int[] row : box) {
            for (int tomato : row) {
                if(tomato == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(result);
    }

    public static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        while (!q.isEmpty()) {
            Pair poll = q.poll();
            int x = poll.x;
            int y = poll.y;
            int time = poll.time;

            result = Math.max(result, time);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    q.offer(new Pair(nx, ny, time + 1));
                }
            }
        }
    }
}