import java.io.*;
import java.util.*;

public class Main {

    static int[][] times;
    static int cnt = 0, end_time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    //회의의 수
        times = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            times[i][0] = Integer.parseInt(st.nextToken()); //회의 시작 시간
            times[i][1] = Integer.parseInt(st.nextToken()); //회의 종료 시간

        }

        //종료시간 기준 오름차순, 종료시간이 같으면 시작시간 기준 오름차순
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0]-o2[0] : o1[1] - o2[1];
            }
        });

        cnt = 1;
        end_time = times[0][1];
        for (int i = 1; i < n; i++) {
            if (end_time <= times[i][0]) {
                cnt++;
                end_time = times[i][1];
            }
        }
        System.out.println(cnt);
    }
}