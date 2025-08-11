import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * G5 7569 토마토
 */

class Pos {
    int x;
    int y;
    int z;
    int day;

    public Pos(int x, int y, int z, int day) {
        this.x = x; //높이
        this.y = y; //행
        this.z = z; //열
        this.day = day;
    }
}


public class Main {

    static int m, n, h, result = 0;
    static int[][][] tomatoes;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomatoes = new int[h][n][m];
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatoes[i][j][k] == 1) {
                        q.add(new Pos(i, j, k, 0));
                    }
                    if (tomatoes[i][j][k] == 0) {
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 0) {
            System.out.println(0);
        } else {
            System.out.println(bfs());
        }

    }

    public static int bfs() {

        while (!q.isEmpty()) {
            Pos poll = q.poll();

            result = Math.max(result, poll.day);
            for (int i = 0; i < 6; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                int nz = poll.z + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= h || ny >= n || nz >= m || tomatoes[nx][ny][nz] == -1) {
                    continue;
                }

                if (tomatoes[nx][ny][nz] == 0) {
                    q.offer(new Pos(nx, ny, nz, poll.day + 1));
                    tomatoes[nx][ny][nz] = 1;
                }
            }
        }

        //토마토가 모두 익지 못하는 상황
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }
        return result;
    }
}