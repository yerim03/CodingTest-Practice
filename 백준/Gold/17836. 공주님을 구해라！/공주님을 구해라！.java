import java.io.*;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * S1 1743 음식물 피하기
 */

class Pair {
    int x;
    int y;
    boolean flag;
    int time;

    public Pair(int x, int y, boolean flag, int time) {
        this.x = x;
        this.y = y;
        this.flag = flag;
        this.time = time;
    }
}

public class Main {

    static int n, m, t, result = Integer.MAX_VALUE;
    static int[][] array;
    static boolean[][] visited, visitedSword;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());   //음식물 쓰레기의 개수

        array = new int[n][m];
        visited = new boolean[n][m];
        visitedSword = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(0, 0);

        if (result == -1 || result > t) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }

    }

    public static int bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y, false, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pair poll = q.poll();

            if (poll.x == n - 1 && poll.y == m - 1) {
                return poll.time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                //범위를 벗어나는 경우
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (!poll.flag) {   //그람이 없는 경우
                    //0일경우와 2일 경우
                    if (!visited[nx][ny] && array[nx][ny] == 0) {
                        q.offer(new Pair(nx, ny, poll.flag, poll.time + 1));
                    } else if (!visited[nx][ny] && array[nx][ny] == 2){
                        q.offer(new Pair(nx, ny, true, poll.time + 1));
                    }
                    visited[nx][ny] = true;
                } else {    //그람이 있는 경우
                    //0, 1에 상관없이 방문하지 않은 칸이라면 무조건 이동
                    if (!visitedSword[nx][ny]) {
                        q.offer(new Pair(nx, ny, poll.flag, poll.time + 1));
                        visitedSword[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}