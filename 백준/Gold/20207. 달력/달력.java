import java.io.*;
import java.util.*;

/**
 * G5 20207 달력
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    //일정의 개수
        int[] schedule = new int[367];
        //일정들의 시작날짜, 종료날짜 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for (int j = s; j <= e; j++) {
                schedule[j]++;
            }
        }

        int start = 365, end = 1, height = 0;
        int result = 0;
        for (int i = 1; i < schedule.length; i++) {
            if (schedule[i] == 0) {
                result += height * (end - start + 1);
                height = 0;
                end = 1;
                start = 365;
            } else {
                start = Math.min(start, i);
                end = Math.max(end, i);
                height = Math.max(height, schedule[i]);
            }
        }
        System.out.println(result);
    }
}