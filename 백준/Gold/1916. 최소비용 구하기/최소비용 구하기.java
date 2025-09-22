import java.io.*;
import java.util.*;

/**
 * S5 1916 최소비용 구하기
 */
class Bus implements Comparable<Bus> {
    int cityNum;
    int cost;

    public Bus(int cityNum, int cost) {
        this.cityNum = cityNum;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bus b) {
        return cost - b.cost;
    }
}

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int n, m, start, end, result = Integer.MAX_VALUE;
    static ArrayList<Bus>[] bus;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    //도시의 개수
        m = Integer.parseInt(br.readLine());    //버스의 개수


        bus = new ArrayList[n + 1]; //버스 정보
        dist = new int[n + 1];  //각 도시에 도착하는데 드는 최소 비용
        for (int i = 0; i <= n; i++) {
            bus[i] = new ArrayList<>();
        }
        Arrays.fill(dist, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            bus[s].add(new Bus(e, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());   //출발 도시
        end = Integer.parseInt(st.nextToken());     //도착 도시

        dijkstra(start, end);
        System.out.println(dist[end]);
    }

    public static void dijkstra (int start, int end) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        pq.add(new Bus(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Bus current = pq.poll();
            int curCityNum = current.cityNum;   //현재 도시번호
            int curCost = current.cost; //현재 도시로 이동하는데 드는 최소비용

            if(visited[curCityNum]) continue;
            visited[curCityNum] = true;

            for (Bus b : bus[curCityNum]) {
                int nextCityNum = b.cityNum;    //현재에서 이동 가능한 다음 도시번호
                if(dist[nextCityNum] > curCost + b.cost) {
                    dist[nextCityNum] = curCost + b.cost;
                    pq.add(new Bus(nextCityNum, dist[nextCityNum]));
                }
            }
        }
    }
}