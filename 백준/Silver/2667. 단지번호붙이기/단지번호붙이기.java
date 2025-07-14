import java.io.*;
import java.util.*;

/**
 *  S1 2667 단지번호붙이기
 */

class House {
    int x;
    int y;

    public House(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int n, numCnt;
    static int[][] map;
    static boolean[][] visited;
    static Queue<House> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> houseCnt = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    //지도의 크기

        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int cnt = bfs(i, j, 0);
                    numCnt++;  //단지 수 증가
                    houseCnt.add(cnt);
                }
            }
        }

        Collections.sort(houseCnt); //오름차순 정렬

        StringBuilder sb = new StringBuilder();
        sb.append(numCnt + "\n");
        for (int i = 0; i < houseCnt.size(); i++) {
            sb.append(houseCnt.get(i) + "\n");
        }
        System.out.println(sb);
    }

    public static int bfs(int x, int y, int count) {
        visited[x][y] = true;
        q.offer(new House(x, y));
        count++;


        while (!q.isEmpty()) {
            House house = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = house.x + dx[i];
                int ny = house.y + dy[i];

                //범위를 벗어나는 경우
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    q.offer(new House(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }

        return count;
    }
}