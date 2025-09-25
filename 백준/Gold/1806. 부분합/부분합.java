import java.io.*;
import java.util.*;

/**
 * G4 1806 부분합
 */

public class Main {

    static int n, s, result = Integer.MAX_VALUE;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        String[] strings = br.readLine().split(" ");
        int[] numbers = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        prefixSum = new int[n];

        int start = 0, end = 0;
        int sum = numbers[0];
        while(true) {
            if(end >= n - 1 && sum < s) {
                break;
            }

            if(sum >= s) {
                result = Math.min(result, end - start + 1);
                sum -= numbers[start];
                start++;
            } else {
                end++;
                sum += numbers[end];
            }
        }
        System.out.println((result == Integer.MAX_VALUE) ? "0" : result);
    }
}