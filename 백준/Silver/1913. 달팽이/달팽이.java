import java.io.*;

public class Main {

    public static int[][] array;
    public static int value = 1;
    //value의 이동방향 - 우, 하, 좌, 상
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    //표의 크기
        int m = Integer.parseInt(br.readLine());

        array = new int[n + 1][n + 1];

        //시작은 (n/2, n/2)
        x = n / 2;
        y = n / 2;
        array[x][y] = value++;    //시작
        for (int i = 1; i <= (n / 2); i++) {
            int index = 0;  //value의 방향벡터
            x -= 1;
            array[x][y] = value++;

            //우
            calculate(index, (i * 2) - 1);

            //하
            index++;
            calculate(index, i * 2);

            //좌
            index++;
            calculate(index, i * 2);

            //상
            index++;
            calculate(index, i * 2);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
                if (array[i][j] == m) {
                    sb.append((i+1) + " " + (j+1));
                }
            }
            System.out.println();
        }
        System.out.println(sb);
    }

    public static void calculate(int index, int end) {
        for (int j = 1; j <= end; j++) {
            x += dx[index];
            y += dy[index];
            array[x][y] = value++;
        }
    }
}