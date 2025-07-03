import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * S1 7562 나이트의 이동
 */

class Pair {
    int x;
    int y;
    int cnt;

    public Pair(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {

    static int t, n;
    static boolean[][] chessBoard;
    static int curX, curY, moveX, moveY;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        while (t > 0) {
            n = Integer.parseInt(br.readLine());    //체스판의 크기
            chessBoard = new boolean[n][n];
            st = new StringTokenizer(br.readLine());    //나이트의 현재 위치
            curX = Integer.parseInt(st.nextToken());
            curY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());    //나이트가 이동할 위치
            moveX = Integer.parseInt(st.nextToken());
            moveY = Integer.parseInt(st.nextToken());

            bfs(curX, curY);
            System.out.println(result);

            t--;
        }
    }


    public static void bfs(int curX, int curY) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(curX, curY, 0));
        chessBoard[curX][curY] = true;

        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        while (!q.isEmpty()) {
            Pair poll = q.poll();
            curX = poll.x;
            curY = poll.y;
            int cnt = poll.cnt;

            if (curX == moveX && curY == moveY) {
                result = cnt;
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                //체스판의 범위를 벗어나는 경우
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (!chessBoard[nx][ny]) {
                    q.offer(new Pair(nx, ny, cnt + 1));
                    chessBoard[nx][ny] = true;
                }
            }
        }
    }
}

/* 나이트(x, y)가 한번에 이동할 수 있는 칸의 위치
* (x-2, y-1), (x-2, y+1)
* (x-1, y-2), (x-1, y+2)
* (x+1, y-2), (x+1, y+2)
* (x+2, y-1), (x+2, y+1)*/