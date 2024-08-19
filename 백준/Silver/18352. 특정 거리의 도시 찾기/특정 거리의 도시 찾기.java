import java.io.*;
import java.util.*;

/*
* 특정도시 X로부터의 최단거리가 K인 모든 도시의 번호 출력
* */
public class Main {
    public static int n, m, k, x;
    public static ArrayList<Integer> result = new ArrayList<>();    //최단거리 K인 도시
    public static ArrayList<Integer>[] graph;
    public static Queue<Integer> q = new LinkedList<>();
    public static int[] distance;   //방문  & 최단 거리

    public static void bfs(int start) {
        distance[start]++;  //시작 노드 방문 처리
        q.offer(start);

        while (!q.isEmpty()) {
            int current = q.poll();
            //최단 거리가 K이면 result 리스트에 추가
            if (distance[current] == k) {
                result.add(current);
            }

            for (int i : graph[current]) {
                if (distance[i] == -1) {  //방문하지 않은 도시라면
                    distance[i] = distance[current] + 1;    //(시작->현재 까지 거리) + 1
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //전체 도시의 개수
        m = Integer.parseInt(st.nextToken());   //전체 도로의 개수
        k = Integer.parseInt(st.nextToken());   //거리 정보
        x = Integer.parseInt(st.nextToken());   //출발 도시 번호

        graph = new ArrayList[n + 1];
        distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = -1;
        }

        //도로 정보 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
        }


        bfs(x);
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        if (result.isEmpty()) { //최단거리 K인 도시가 존재하지 않으면 -1 출력
            sb.append(-1);
        } else {
            for (int i = 0; i < result.size(); i++) {   //최단거리 K인 도시가 존재하면 오름차순으로 출력
                sb.append(result.get(i) + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}