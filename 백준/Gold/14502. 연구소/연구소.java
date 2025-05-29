import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Virus {
    int x;
    int y;

    public Virus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, m;
    static int maxSafeArea = Integer.MIN_VALUE;
    static int[][] map;
    static ArrayList<Virus> virusPositions = new ArrayList<>(); //바이러스의 위치를 담는 리스트
    static Queue<Virus> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                //바이러스가 있는 위치를 리스트에 따로 저장
                if (map[i][j] == 2) {
                    virusPositions.add(new Virus(i, j));
                }
            }
        }

        dfs(0);
        System.out.println(maxSafeArea);
    }

    public static void dfs(int cnt) {
        //종료조건 - 새로 세운 벽의 개수가 3개일 때 종료
        if (cnt == 3) {
            countSafeArea();    //안전 영역의 개수 세기
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void countSafeArea() {
        int[][] copyMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        //바이러스 감염
        for (Virus virusPosition : virusPositions) {
            int x = virusPosition.x;
            int y = virusPosition.y;
            virus(copyMap, x, y);
        }

        //안전 영역의 개수 세기
        int safeArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }

    public static void virus(int[][] copyMap, int x, int y) {
        queue.offer(new Virus(x, y));

        while (!queue.isEmpty()) {
            Virus poll = queue.poll();
            x = poll.x;
            y = poll.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //공간을 벗어날 경우 무시
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    queue.offer(new Virus(nx, ny));
                }
            }
        }
    }
}