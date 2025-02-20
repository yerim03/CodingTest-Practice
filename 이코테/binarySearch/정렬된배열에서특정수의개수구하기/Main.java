package binarySearch.정렬된배열에서특정수의개수구하기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int x, count = 0;
    public static int[] array;

    //x가 처음 위치를 찾는 이진 탐색
    public static int firstIndex(int start, int end) {
        while(start < end){
            int mid = (start + end) / 2;
            if(array[mid] >= x){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    //x의 마지막 위치를 찾는 이진 탐색
    public static int lastIndex(int start, int end) {
        while(start < end){
            int mid = (start + end) / 2;
            if(array[mid] > x){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int first = firstIndex(0, n);
        int last = lastIndex(0, n);

        System.out.println((last - first == 0) ? -1 : last - first);
    }
}