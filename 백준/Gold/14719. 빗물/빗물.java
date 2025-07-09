import java.io.*;
import java.util.StringTokenizer;

/**
 * G5 14719 빗물
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] array = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 1; i < w - 1; i++) {
            int current = array[i]; //현재 벽의 높이
            int maxLeft = 0;    //왼쪽 최대 블록 높이
            int maxRight = 0;   //오른쪽 최대 블록 높이

            //왼쪽에서 최대 높이 찾기
            for (int j = 0; j < i; j++) {
                maxLeft = Math.max(maxLeft, array[j]);
            }

            //오른쪽에서 최대 높이 찾기
            for (int j = i + 1; j < w; j++) {
                maxRight = Math.max(maxRight, array[j]);
            }

            //왼쪽과 오른쪽의 최대 높이를 비교해서 더 작은 높이 찾기
            int m = Math.min(maxLeft, maxRight);
            if (m > current) {
                result += m - current;
            }
        }
        System.out.println(result);
    }
}