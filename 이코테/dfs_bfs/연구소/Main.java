package dfs_bfs.연구소;

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
    static int[][] map, copyMap;
    static ArrayList<Virus> virusPositions = new ArrayList<>(); //바이러스의 위치를 담는 리스트
    static Queue<Virus> queue = new LinkedList<>();
    //바이러스의 이동방향
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
        //새로 새운 벽이 3개일 경우
        if (cnt == 3) {
            virus();    //바이러스가 퍼지고 안전영역 구하기
            return;
        }

        //처음부터 순서대로 돌면서 '0' 부분에 벽 세우고 재귀호출
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

    public static void virus() {
        copyMap = new int[n][m];

        //원본 배열은 그대로 두고 복사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        //각 바이러스 위치에서 전파 시작
        for (Virus v : virusPositions) {
            bfs(v.x, v.y);
        }
        //안전영역의 크기 구하기
        countSafeArea();
    }

    //바이러스가 퍼지는 것을 계산하는 함수
    public static void bfs(int x, int y) {
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


    //안전 영역의 크기를 세는 함수
    public static void countSafeArea() {
        int safeArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, safeArea);  //안전영역 최댁랎 구하기
    }
}