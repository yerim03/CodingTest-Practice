package implementation.상하좌우;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //공간의 크기
        sc.nextLine();
        String[] plans = sc.nextLine().split(" ");  //이동할 계획서

        /* L, R, U, D에 따른 이동 방향
        * L -> (0, -1) 이동
        * R -> (0, 1) 이동
        * U -> (-1, 0) 이동
        * D -> (1, 0) 이동
        * */
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        String[] moveTypes = {"L", "R", "U", "D"};

        int x = 1, y = 1;   //시작 좌표
        for (int i = 0; i < plans.length; i++) {
            String plan = plans[i];
            int nx = 0, ny = 0;
            for (int j = 0; j < moveTypes.length; j++) {
                if (plan.equals(moveTypes[j])) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            if (nx < 1 || ny < 1 || nx > n || ny > n) {
                continue;
            }
            x = nx;
            y = ny;

        }
        System.out.println(x + " " + y);
    }
}