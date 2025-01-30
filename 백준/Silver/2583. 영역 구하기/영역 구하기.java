import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int m, n, k;
    public static int size = 0;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] map;
    public static ArrayList<Integer> result = new ArrayList<>();

    public static boolean dfs(int x, int y) {

        //주어진 모눈종이 영역을 벗어나면 종료
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }

        if (map[x][y] == 0) {
            map[x][y] = 1;  //방문 처리
            size++;

            //상, 하, 좌, 우으로 방문
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            //직사각형에 포함된 영역을 1로 초기화
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j) == true) {
                    result.add(size);
                    size = 0;
                }
            }
        }
        System.out.println(result.size());

        //오름차순 정렬 후 출력
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}