package dfs_bfs.특정거리의도시찾기;

import java.io.*;
import java.util.*;

public class Main1 {

    public static int n, m, k, x;
    public static Queue<Integer> q = new LinkedList<>();
    public static ArrayList<ArrayList<Integer>> cities = new ArrayList<>(); //도로 정보
    public static int[] distance;   //각 도로의 최단거리

    public static void bfs(int start) {
        q.offer(start);     //출발 도시 큐에 삽입

        while (!q.isEmpty()) {
            int now = q.poll();   //현재 도시번호를 큐에서 꺼낸다.

            //현재 도시에서 이동할 수 있는 모든 도시를 확인한다.
            for (int i = 0; i < cities.get(now).size(); i++) {
                int next_city = cities.get(now).get(i);
                if (distance[next_city] == -1) {    //이동하지 않은 도시라면 큐에 삽입하고 거리계산
                    distance[next_city] = distance[now] + 1;    //출발도시에서 해당 도시까지의 거리 계산
                    q.offer(next_city);     //큐에 삽입
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //도시의 개수
        m = Integer.parseInt(st.nextToken());   //도로의 개수
        k = Integer.parseInt(st.nextToken());   //거리 정보
        x = Integer.parseInt(st.nextToken());   //출발 도시의 번호

        distance = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            cities.add(new ArrayList<>());
            distance[i] = -1;   //-1로 두는 것은 해당 도시를 방문하지 않았음을 나타내기 위함
        }

        distance[x] = 0;    //출발 도시는 0

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cities.get(a).add(b);
        }


        bfs(x);

        boolean check = false;
        //모든 도시까지의 최단 거리 중 최단거리가 k인 도시를 찾는다.
        for (int i = 0; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        //최단거리가 k인 도시가 없다면 -1 출력
        if (check == false) {
            System.out.println(-1);
        }

    }
}
