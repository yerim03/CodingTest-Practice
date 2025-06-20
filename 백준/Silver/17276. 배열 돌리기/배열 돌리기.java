import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int t, n, d;
    static int[][] array;
    static int[][] copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   //배열의 크기
            d = Integer.parseInt(st.nextToken());   //각도

            array = new int[n + 1][n + 1];
            copy = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                    copy[i][j] = array[i][j];
                }
            }

            int midIdx = (n + 1) / 2;

            if (d > 0) {    //시계방향
                rotateRight(d / 45, midIdx);
            } else if (d < 0) {  //반시계방향
                rotateLeft(Math.abs(d) / 45, midIdx);
            }

            //결과 출력
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(copy[i][j] + " ");
                }
                System.out.println();
            }
        }
    }


    //시계방향
    public static void rotateRight(int d, int midIdx) {
        while(d > 0) {
            for (int i = 1; i <= n; i++) {
                //주대각선(왼쪽대각선) -> 가운데 열
                copy[i][midIdx] = array[i][i];
                //가운데 열 -> 부대각선(오른쪽대각선)
                copy[i][n - i + 1] = array[i][midIdx];
                //부대각선(오른쪽대각선) -> 가운데 행
                copy[midIdx][n - i + 1] = array[i][n - i + 1];
                //가운데 행 -> 주대각선(왼쪽대각선)
                copy[i][i] = array[midIdx][i];
            }
            d--;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    array[i][j] = copy[i][j];
                }
            }
        }
    }

    //반시계방향
    public static void rotateLeft(int d, int midIdx) {
        while(d > 0) {
            for (int i = 1; i <= n; i++) {
                //주대각선(왼쪽대각선) -> 가운데 행
                copy[midIdx][i] = array[i][i];
                //가운데 행 -> 부대각선(오른쪽 대각선)
                copy[n - i + 1][i] = array[midIdx][i];
                //부대각선(오른쪽 대각선) -> 가운데 열
                copy[n - i + 1][midIdx] = array[n - i + 1][i];
                //가운데 열 -> 주대각선(왼쪽 대각선)
                copy[i][i] = array[i][midIdx];
            }
            d--;
            
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    array[i][j] = copy[i][j];
                }
            }
        }
    }
}