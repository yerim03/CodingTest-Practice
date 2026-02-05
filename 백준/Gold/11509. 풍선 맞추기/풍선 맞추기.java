import java.io.*;
import java.util.*;

/**
 * G5 11509 풍선맞추기
 * https://www.acmicpc.net/problem/11509
*/

public class Main { ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        int[] arrows = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            if(arrows[h] > 0) { //현재 날아가는 화살 중 h높이가 있다면 해당 화살을 사용해서 현재 풍선(h) 터트림
                arrows[h]--;
            } else {    //현재 날아가는 화살 중 h높이가 없다면 새로운 화살 추가
                cnt++;
            }
            arrows[h - 1]++;    //풍선을 맞힌 화살은 높이가 1 내려감
        }
        System.out.println(cnt);

    }
}