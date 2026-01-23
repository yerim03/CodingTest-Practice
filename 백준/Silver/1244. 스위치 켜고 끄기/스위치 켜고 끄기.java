import java.io.*;
import java.util.*;

/**
 * S4 1244 스위치 켜고 끄기
 * */

public class Main {

    public static int[] switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    //스위치 개수
        //스위치 상태 입력
        switches = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());    //학생 수
        //학생 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());  //성별
            int number = Integer.parseInt(st.nextToken());  //부여받은 스위치 번호

            if(gender == 1) {   //남학생일 경우
                for(int j = number; j <= n; j += number) {
                    switches[j] = changeSwitch(switches[j]);
                }
            } else if (gender == 2) {   //여학생일 경우
                switches[number] = changeSwitch(switches[number]);
                int left = number - 1;
                int right = number + 1;
                while (left > 0 && right <= n) {
                    if(switches[left] == switches[right]) {
                        switches[left] = changeSwitch(switches[left]);
                        switches[right] = changeSwitch(switches[right]);
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(switches[i] + " ");
            if(i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int changeSwitch(int state) {
        return (state == 0) ? 1 : 0;
    }
}