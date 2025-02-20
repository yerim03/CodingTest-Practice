package binarySearch.떡볶이떡만들기;

import java.io.*;
import java.util.*;

public class Main {

    public static int binary_search(int[] array, int target, int start, int end) {
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            //잘랐을 때 떡의 양 계산
            for (int i : array) {
                if (i > mid) {
                    sum += (i - mid);
                }
            }

            if (sum < target) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            max = Math.max(array[i], max);
        }

        System.out.println(binary_search(array, m, 0, max));
    }
}
