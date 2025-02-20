package binarySearch.고정점찾기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int search_fixed_point(int[] array, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;    //중간값

            if (array[mid] == mid) {    //원소값과 그 인덱스값이 같으면 고정점
                return mid;
            } else if (array[mid] < mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(search_fixed_point(array, 0, n));
    }
}
