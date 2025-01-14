package sort.두배열의원소교체;

/*
배열 A의 모든 원소의 합이 최대가 되도록 바꿔치기 수행
배열 A의 가장 작은 수와 배열 B의 가장 큰 수를 바꿔치기 한다.
배열 A는 오름차순, 배열 B는 내림차순 정렬한 후, 첫 번째 인덱스부터 바꿔치기 수행
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //원소 개수
        int k = Integer.parseInt(st.nextToken());   //바꿔치기 연산 횟수

        Integer[] arrayA = new Integer[n];
        Integer[] arrayB = new Integer[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrayA[i] = Integer.parseInt(st1.nextToken());
            arrayB[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arrayA);    //배열A 오름차순 정렬
        Arrays.sort(arrayB, Collections.reverseOrder());    //배열B 내림차순 정렬

        for (int i = 0; i < k; i++) {
            if (arrayA[i] < arrayB[i]) {    //배열A의 원소가 배열B의 원소보다 작을 때만 바꿔치기 수행
                int temp = arrayA[i];
                arrayA[i] = arrayB[i];
                arrayB[i] = temp;
            } else {
                break;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arrayA[i];
        }

        System.out.println(sum);
    }
}
