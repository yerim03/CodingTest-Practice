import java.io.*;
import java.util.*;

/**
 * G4 16234 인구이동
 */

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, l, r, result = 0;
    static boolean isMoved = false;  //이동 플래그
    static int[][] array;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //땅의 크기
        l = Integer.parseInt(st.nextToken());   //최소 인구차이
        r = Integer.parseInt(st.nextToken());   //최대 인구차이

        array = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();
        System.out.println(result);
    }



    public static void move() {
        while(true) {
           //하루를 시작할 때마다 visited, isMoved 초기화
            visited = new boolean[n][n];
            isMoved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            if(isMoved == false) break;
            else result++;
        }

    }

    public static void bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        ArrayList<Pos> union = new ArrayList<>();   //연합국들의 좌표
        q.offer(new Pos(x, y));
        union.add(new Pos(x, y));
        visited[x][y] = true;

        int peopleCnt = array[x][y];    //연합한 나라의 인구 총합

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            x = pos.x;
            y = pos.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                int diff = Math.abs(array[x][y] - array[nx][ny]);   //두 나라 간 인구 차이
                if (!visited[nx][ny] && diff >= l && diff <= r) {
                    isMoved = true; //연합이 발생하면 인구이동
                    q.offer(new Pos(nx, ny));
                    union.add(new Pos(nx, ny));
                    visited[nx][ny] = true; //방문처리
                    peopleCnt += array[nx][ny];
                }
            }
        }

        int unionCnt = peopleCnt / union.size();    //연합 인구 수
        //연합국들의 인구 이동
        for (int i = 0; i < union.size(); i++) {
            Pos pos = union.get(i);
            array[pos.x][pos.y] = unionCnt;
        }
    }
}