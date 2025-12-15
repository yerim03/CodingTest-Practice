import java.io.*;
import java.util.*;

/**
 * S3 1966 프린터큐
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   //문서의 개수
            int m = Integer.parseInt(st.nextToken());   //문서의 개수

            Queue<int[]> q = new LinkedList<>();    //문서가 주어진 순서대로
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); //문서의 중요도순으로

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                q.offer(new int[]{i, priority});
                pq.offer(priority);
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                int[] poll = q.poll();  //현재 문서

                if (poll[1] != pq.peek()) { //현재문서의 중요도가 가장 높지 않은 경우, 뒤로 재배치
                    q.offer(poll);
                } else {    //현재문서의 중요도가 가장 높은 경우, 인쇄
                    pq.poll();
                    cnt++;
                    if (poll[0] == m) { //현재 인쇄된 문서가 알고자 하는 문서일 경우
                        break;
                    }
                }
            }
            System.out.println(cnt);
            t--;
        }
    }
}