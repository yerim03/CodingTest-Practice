package dynamicProgramming.개미전사;

import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    //식량창고의 개수

        int[] d = new int[101];
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        d[0] = 0;
        d[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + array[i]);
        }

        System.out.println(d[n-1]);
    }
}