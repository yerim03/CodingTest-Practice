import java.io.*;
import java.util.*;

/**
 * G4 13422 도둑
 */

public class Main {

    static int t, n, m, k;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        while(t > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   //집의 개수
            m = Integer.parseInt(st.nextToken());   //돈을 훔칠 연속된 집의 개수
            k = Integer.parseInt(st.nextToken());   //

            int[] house = new int[n];
            int cnt = 0;
            int money = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                house[i] = Integer.parseInt(st.nextToken());
            }


            for (int i = 0; i < m; i++) {
                money += house[i];
            }
            if(money < k)   cnt++;

            if(n != m) {
                for (int i = 1; i < n; i++) {
                    money -= house[i - 1];
                    money += house[(i + m - 1) % n];
                    if (money < k) cnt++;
                }
            }
            sb.append(cnt + "\n");

            t--;
        }
        System.out.println(sb);
    }
}