package binarySearch.공유기설치;

import java.io.*;
import java.util.StringTokenizer;

/*
* 가장 인접한 두 공유기 사이의 거리가 최대
* */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        //n개의 집의 좌표
        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

    }
}
