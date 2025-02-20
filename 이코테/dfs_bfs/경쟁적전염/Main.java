package dfs_bfs.경쟁적전염;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 * 바이러스의 정보들을 담은 노드 클래스 만들기
 * 리스트에 담고 바이러스 종류번호를 기준으로 오름차순 정렬
 * 리스트에 있는 바이러스를 큐에 넣고 bfs 시작
 * 큐에서 하나씩 꺼내서 상, 하, 좌, 우를 탐색하며 증식이 가능할 경우 시간 증가
 * s초가 됐을 경우 종료하고
 * */
public class Main {
    static class Node {
        int x;  //바이러스 위치의 행
        int y;  //바이러스 위치의 열
        int virus;  //바이러스 종류
        int time;   //바이러스가 몇 초에 증식되었는지를 나타내는 시간

        Node(int x, int y, int virus, int time) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.time = time;
        }
    }

    public static int n, k, s;
    public static int[][] map;
    public static Queue<Node> q = new LinkedList<>();

    public static void bfs() {

        //상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            if (cur.time == s) {
                return;
            }

            //상, 하, 좌, 우로 움직이면서 바이러스가 증식할 수 있는지 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //시험관 영역을 벗어나면 무시
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                //해당 칸이 비어있으면 바이러스가 증식 가능
                if (map[nx][ny] == 0) {
                    map[nx][ny] = cur.virus;
                    q.offer(new Node(nx, ny, cur.virus, cur.time + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //시험관 크기
        k = Integer.parseInt(st.nextToken());   //바이러스 종류 수

        map = new int[n][n];
        ArrayList<Node> list = new ArrayList<>();   //바이러스 정보를 담는 리스트
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {   //리스트에 바이러스 정보 담기
                    list.add(new Node(i, j, map[i][j], 0));
                }
            }
        }

        //리스트를 바이러스 종류 번호를 기준으로 오름차순 정렬
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.virus - o2.virus;
            }
        });

        //리스트를 큐에 삽입
        for (Node node : list) {
            q.offer(node);
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());   //s초
        int x = Integer.parseInt(st.nextToken());   //s초 후 바이러스의 행 위치
        int y = Integer.parseInt(st.nextToken());   //s초 후 바이러스의 열 위치

        bfs();

        System.out.println(map[x-1][y-1]);
    }
}
