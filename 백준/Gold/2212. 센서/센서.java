import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * G5 2212 센서
 */

public class Main {

    static int n, k, sum = 0;
    static int[] array;
    static int[] diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());   //센서의 개수
        k = Integer.parseInt(br.readLine());   //집중국의 개수

        array = new int[n];
        diff = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array); //오름차순 정렬

        //옆에 있는 센서들간의 거리 차 구하기
        for (int i = 1; i < n; i++) {
            diff[i - 1] = array[i] - array[i - 1];
        }

        Arrays.sort(diff);

        for (int i = 0; i < diff.length - (k - 1); i++) {
            sum += diff[i];
        }
        System.out.println(sum);
    }
}