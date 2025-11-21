import java.io.*;
import java.util.*;

/**
 * G4 2110 공유기설치
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int result = 0;
        int left = 1;
        int right = house[n - 1] - house[0];

        //이분탐색 시작
        while(left <= right) {
            //첫 번째 집에는 무조건 설치
            int cnt = 1;
            int before = house[0];

            int mid = (left + right) / 2; //공유기를 설치할 거리의 최솟값

            //공유기 설치
            for (int i = 1; i < n; i++) {
                if(house[i] - before >= mid) {
                    cnt++;
                    before = house[i];
                }
            }

            //설치한 공유기 개수 확인
            if(cnt >= c) {   //c보다 많거나 같으면 최소 거리를 늘린다.
                result = mid;
                left = mid + 1;
            } else {    //c보다 작으면 최소 거리를 줄인다.
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}