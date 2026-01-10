import java.io.*;
import java.util.*;

/**
 * G5 1092 배
 */


public class Main {

    static int n, m, cnt = 0;
    static ArrayList<Integer> crane = new ArrayList<>();
    static ArrayList<Integer> boxes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    //크레인 수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());    //박스 수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());    //크레인 내림차순 정렬
        Collections.sort(boxes, Collections.reverseOrder());    //박스 내림차순 정렬

        //모든 박스를 배로 옮길 수 없는 경우
        if (boxes.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }

        while (!boxes.isEmpty()) {
            int craneIdx = 0;
            int boxIdx = 0;

            //박스를 모두 돌면서 1회차에 크레인으로 옮길 수 있는 박스 탐색
            while(boxIdx < boxes.size()) {
                if(craneIdx >= n) break;
                if(boxes.get(boxIdx) <= crane.get(craneIdx)) {  //크레인으로 박스를 옮길 수 있는 경우
                    boxes.remove(boxIdx);   //박스 제거
                    craneIdx++;
                } else {
                    boxIdx++;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
        return;
    }
}