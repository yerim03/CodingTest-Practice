package greedy.숫자카드게임;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //행
        int m = sc.nextInt();   //열

        int[][] cards = new int[n][m];
        int result = 0;
        //각 행마다 가장 작은 수를 찾고, 그 수들 중에서 가장 큰 수를 찾는다.
        for (int i = 0; i < n; i++) {
            int row_min = 10001;
            for (int j = 0; j < m; j++) {
                cards[i][j] = sc.nextInt();
                row_min = Math.min(cards[i][j], row_min);
            }
            result = Math.max(row_min, result);
        }
        System.out.println(result);
    }
}
