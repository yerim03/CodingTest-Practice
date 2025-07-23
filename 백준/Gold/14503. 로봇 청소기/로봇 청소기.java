import java.io.*;
import java.util.*;

/**
 * G5 14503 로봇청소기
 */

public class Main {

    static int n, m, r, c, d, count = 0;
    static int[][] rooms;
    static int[] dr = {-1, 0, 1, 0}; //북, 동, 남, 서
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken()); //방향

        rooms = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean();
        System.out.println(count);
    }

    public static void clean() {
        while(true) {
            if (rooms[r][c] == 0) { //현재 칸 청소
                rooms[r][c] = -1;   //청소완료 상태로 변경
                count++;    //청소횟수 증가
            }

            int cleanCnt = 0;   //이미 청소된 칸 or 벽의 개수
            //현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는지 탐색
            for (int i = 0; i < 4; i++) {
                d = (d == 0) ? 3 : d - 1; //반시계방향으로 90도 회전

                int nr = r + dr[d];
                int nc = c + dc[d];

                //방의 범위를 벗어나는 경우
                if(nr < 0 || nc < 0 || nr >= n || nc >= m)  continue;

                //이미 청소된 칸이거나 벽일 경우
                if (rooms[nr][nc] == 1 || rooms[nr][nc] == -1)  cleanCnt++;

                //청소되지 않은 빈 칸이 있는 경우 한 칸 전진
                if(rooms[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    break;
                }
            }

            //주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if(cleanCnt == 4) {
                int nr = r - dr[d];
                int nc = c - dc[d];

                //범위를 벗어나거나 뒤쪽이 벽이라 후진할 수 없는 경우
                if(nr < 0 || nc < 0 || nr >= n || nc >= m || rooms[nr][nc] == 1) {
                    return;
                }
                //한 칸 후진
                r = nr;
                c = nc;
            }
        }

    }
}