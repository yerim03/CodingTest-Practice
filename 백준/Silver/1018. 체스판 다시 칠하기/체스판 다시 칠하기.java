import java.io.*;
import java.util.StringTokenizer;

/**
 *  s3 1018 체스판 다시 칠하기
 */

public class Main {

    static String[][] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array = new String[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                array[i][j] = String.valueOf(str.charAt(j));
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int cntB = makeChessBoard(i, j,"B");    //B로 시작하는 경우
                int cntW = makeChessBoard(i, j,"W");    //W로 시작하는 경우
                result = Math.min(result, Math.min(cntB, cntW));
            }
        }
        System.out.println(result);
    }

    public static int makeChessBoard(int x, int y, String startCh) {
        int cnt = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (!array[i][j].equals(startCh)) {
                    cnt++;
                }

                if (j == y + 7) {   //한 줄의 마지막이면 변경하지 않음
                    continue;
                }
                //다음 칸 비교를 위해 B->W, W->B로 변경
                if (startCh.equals("B")) {
                    startCh = "W";
                } else {
                    startCh = "B";
                }
            }
        }
        return cnt;
    }
}