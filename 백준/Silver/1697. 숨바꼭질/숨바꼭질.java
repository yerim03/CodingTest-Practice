import javax.print.attribute.IntegerSyntax;
import java.io.*;
import java.util.*;

/**
 *  s1 1697 숨바꼭질
 */

class Pos {
    int x;
    int time;

    public Pos(int x, int time) {
        this.x = x;
        this.time = time;
    }
}

public class Main {

    static int n, k, result = 0;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   //수빈
        k = Integer.parseInt(st.nextToken());   //동생

        bfs();
        System.out.println(result);
    }
    public static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            if (cur.x == k) {
                result = cur.time;
                return;
            }

            int x;
            for (int i = 0; i < 3; i++) {
                if(i == 0) x = cur.x - 1;
                else if(i == 1) x = cur.x + 1;
                else x = cur.x * 2;

                if(x >= 0 && x <= 100000 && !visited[x]) {
                    q.offer(new Pos(x, cur.time + 1));
                    visited[x] = true;
                }
            }
        }
    }
}