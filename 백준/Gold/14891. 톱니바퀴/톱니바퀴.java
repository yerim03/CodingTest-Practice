import java.io.*;
import java.util.*;

/**
 * G5 14891 톱니바퀴
 */

public class Main {

    static int k;
    static int[][] wheels = new int[4][8];
    static int[] direction = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //4개의 톱니바퀴 상태 입력
        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = str.charAt(j) - '0';
            }
        }

        k = Integer.parseInt(br.readLine());    //회전 수
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            simulation(num - 1, dir);
            Arrays.fill(direction, 0);
        }

        int sum = 0, score = 1;
        for (int i = 0; i < 4; i++) {
            sum += wheels[i][0] == 0 ? 0 : score;
            score *= 2;
        }
        System.out.println(sum);
    }

    public static void simulation(int num, int dir) {
        direction[num] = dir;

        //num번 톱니바퀴의 왼쪽 탐색
        for (int i = num - 1; i >= 0; i--) {
            if (wheels[i + 1][6] != wheels[i][2]) {
                direction[i] = - direction[i + 1];
            } else {
                break;
            }
        }

        //num번 톱니바퀴의 오른족 탐색
        for (int i = num + 1; i < 4; i++) {
            if (wheels[i - 1][2] != wheels[i][6]) {
                direction[i] = - direction[i - 1];
            } else {
                break;
            }
        }

        //회전
        for (int i = 0; i < 4; i++) {
            turn(i, direction[i]);
        }

    }
    
    //회전
    public static void turn(int num, int dir) {
        if (dir == 1) { //시계방향 회전
            //맨 뒤 원소를 맨 앞으로, 나머지는 한 칸씩 뒤로 이동
            int temp = wheels[num][7];
            for (int i = 6; i >= 0; i--) {
                wheels[num][i + 1] = wheels[num][i];
            }
            wheels[num][0] = temp;
        } else if(dir == -1){    //반시게방향 회전
            //맨 앞 원소를 맨 뒤로, 나머지는 한 칸씩 앞으로 이동
            int temp = wheels[num][0];
            for (int i = 1; i < 8; i++) {
                wheels[num][i - 1] = wheels[num][i];
            }
            wheels[num][7] = temp;
        }
    }
}