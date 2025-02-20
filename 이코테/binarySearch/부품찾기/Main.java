package binarySearch.부품찾기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static boolean binary_search(int[] store, int x, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (store[mid] == x) {
                return true;
            } else if (store[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    //가게에 있는 부품의 개수
        int[] store = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            store[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(store); //가게에 있는 부품들 정렬

        int m = Integer.parseInt(br.readLine());    //손님이 요청한 부품의 개수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int customer = Integer.parseInt(st.nextToken());
            boolean result = binary_search(store, customer, 0, n - 1);
            if(result) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}
