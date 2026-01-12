import java.io.*;
import java.util.*;

/**
 * G5 2467 용액
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    //전체 용액의 수

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;

        int mixL = 0;
        int mixR = 0;
        long minValue = Long.MAX_VALUE;

        while(left < right) {
            long sum = array[left] + array[right];
            if(Math.abs(sum) < minValue) {
                mixL = left;
                mixR = right;
                minValue = Math.abs(sum);
            }

            if(sum >= 0) {
                //둘 다 양수이거나
                //|array[left]| < |array[right]|(양수의 절댓값이 더 큰 경우)
                right--;
            } else {
                //둘 다 음수이거나
                //|array[left]| > |array[right]|(음수의 절댓값이 더 큰 경우
                left++;
            }
        }
        System.out.println(array[mixL] + " " + array[mixR]);
    }
}