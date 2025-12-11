import java.io.*;
import java.util.*;

/**
 * G5 2476 두용액
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int answer1 = 0, answer2 = 0;
        int low = 0;
        int high = n - 1;
        int mix_min = Integer.MAX_VALUE;

        while(low < high) {
            int mix = array[low] + array[high];

            if(mix_min > Math.abs(mix)) {
                mix_min = Math.abs(mix);
                answer1 = array[low];
                answer2 = array[high];
            }

            if(mix < 0) {   //|low| > |high|
                low++;
            } else {    //|low| <= |high|
                high--;
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
}