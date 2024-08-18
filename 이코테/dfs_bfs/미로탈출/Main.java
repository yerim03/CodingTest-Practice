package dfs_bfs.미로탈출;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Main {
    public static int n, m;
    public static int[][] graph;

    //상, 하, 좌, 우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};


    public static int bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));

        //큐가 빌때까지 반복
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            x = pair.x;
            y = pair.y;
            System.out.println("poll: "+ x + " " + y);
            //현재 위치(x, y)에서 4 방향(상하좌우)로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                System.out.println(nx + " " + ny);
                //미로 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                //괴물이 없는 부분
                if (graph[nx][ny] == 1) {
                    System.out.println("0 point: " + nx + " " + ny);
                    graph[nx][ny] = graph[x][y] + 1;
                    System.out.println(graph[nx][ny] + "\n");
                    q.offer(new Pair(nx, ny));
                }
            }
        }
        //출구 위치의 값 반환
        return graph[n - 1][m - 1];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n][m];
        //괴물이 있는 부분 0, 괴물이 없는 부분 1
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }
}
