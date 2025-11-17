import java.io.*;
import java.util.*;

/**
 * S3 10025 게으른백곰
 */

public class Main {

    static int n, k, sum = 0, ice_max = 0;
    static int[] array = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());   //얼음 양
            int x = Integer.parseInt(st.nextToken());   //양동이 좌표
            array[x] = g;
        }

        int l = 0, r = 2 * k;
        if(r > 1000000) {
            for(int i = 0; i < 1000001; i++) {
                ice_max += array[i];
            }
        } else {
            for(int i = l; i <= r; i++) {
                sum += array[i];
            }
            ice_max = Math.max(ice_max, sum);

            while(r < 1000000) {
                sum -= array[l];
                sum += array[r + 1];
                l += 1;
                r += 1;
                ice_max = Math.max(ice_max, sum);
            }
        }
        System.out.println(ice_max);
    }
}