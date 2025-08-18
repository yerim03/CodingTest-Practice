import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * S1 21937 작업
 */


public class Main {

    static int n, m, x, cnt = 0;
    static ArrayList<Integer>[] work;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //작업할 개수
        m = Integer.parseInt(st.nextToken());   //작업 순서 정보의 개수

        visited = new boolean[n +1];
        work = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            work[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            work[after].add(before);
        }

        x = Integer.parseInt(br.readLine());    //오늘 끝내야 하는 작업
        dfs(x);
        System.out.println(cnt);
    }

    public static void dfs(int x) {
        if(work[x] != null) {   //작업 x 전에 끝내야 할 작업이 존재하는 경우
            for (int i = 0; i < work[x].size(); i++) {
                int num = work[x].get(i);
                if (!visited[num]) {
                    visited[num] = true;    //작업 방문 처리
                    cnt++;
                    dfs(num);
                }
            }
        }
    }
}