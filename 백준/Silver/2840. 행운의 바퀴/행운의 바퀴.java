import java.io.*;
import java.util.StringTokenizer;

/**
 * S4 2840 행운의바퀴
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //바퀴의 칸 수
        int k = Integer.parseInt(st.nextToken());   //바퀴를 돌리는 횟수

        char[] luckyWheel = new char[n];
        boolean[] alphaVisited = new boolean[26];   //해당 글자(알파벳)을 사용했는지 여부
        for (int i = 0; i < n; i++) {
            luckyWheel[i] = '?';

        }

        int idx = 0;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());   //회전시켰을 때 화살표가 가리키는 글자가 바뀌는 횟수
            char ch = st.nextToken().charAt(0);  //회전이 멈췄을 때 가리키던 글자

            idx = (idx + s) % n;

            if(luckyWheel[idx] == ch) { //입력받은 글자가 같을 경우
                 continue;
            } else if (!alphaVisited[ch - 'A'] && luckyWheel[idx] == '?') {    //입력받은 글자를 사용한 적 없고, 해당 위치에 아직 글자를 채우지 못한 경우
                luckyWheel[idx] = ch;
                alphaVisited[ch - 'A'] = true;   //글자 사용 처리
            } else {
                System.out.println("!");
                return;
            }
        }


        for (int i = idx; i >= 0; i--) {
            sb.append(luckyWheel[i]);
        }

        for (int i = n - 1; i > idx; i--) {
            sb.append(luckyWheel[i]);
        }

        System.out.println(sb);
    }
}