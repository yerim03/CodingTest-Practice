package implementation.왕실의나이트;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cur_location = sc.nextLine();
        int row = cur_location.charAt(1) - '0';  //행
        int column = cur_location.charAt(0) - 96;   //열

        int count = 0;
        int[] dx = {1, 2, -1, -2, -1, -2, 1, 2};
        int[] dy = {2, 1, 2, 1, -2, -1, -2, -1};

        for (int i = 0; i < dx.length; i++) {
            int next_row = row + dx[i];
            int next_column = column + dy[i];

            if (next_row >= 1 && next_row <= 8 && next_column >= 1 && next_column <= 8) {
                count++;
            }
        }
        System.out.println(count);
    }
}
