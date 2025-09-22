import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int idx;
    int weight;

    public Pair(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair o) {
        return weight - o.weight;
    }
}

public class Main {

    static int v, e, k;
    static final int INF = 100000000;
    static ArrayList<Pair>[] list;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(br.readLine());

        list = new ArrayList[v + 1];
        dist = new int[v + 1];
        Arrays.fill(dist, INF);
        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Pair(end, weight));
        }
 //dist 초기화

        dijkstra(k);

        for (int i =1; i <= v; i++) {
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i] + " \n");
        }
        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v + 1];
        pq.add(new Pair(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int curIdx = current.idx;

            if(visited[curIdx]) continue;
            visited[curIdx] = true;

            for(Pair p : list[curIdx]){
                if (dist[p.idx] > dist[curIdx] + p.weight) {
                    dist[p.idx] = dist[curIdx] + p.weight;
                    pq.add(new Pair(p.idx, dist[p.idx]));
                }
            }
        }
    }
}