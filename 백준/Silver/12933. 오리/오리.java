import java.io.*;
import java.util.ArrayList;

/**
 *  S2 12933 오리
 */

public class Main {
    static char[] sound = {'q', 'u', 'a', 'c', 'k'};
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String duck = br.readLine();

        if (duck.charAt(0) != 'q' || duck.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }

        visited = new boolean[duck.length()];
        int cnt = 0;    //오리 개수
        int idx = 0;    //sound 배열의 인덱스
        int cntTrue = 0;
        while (true) {
            ArrayList<Character> quack = new ArrayList<>();
            for (int i = 0; i < duck.length(); i++) {
                char s = duck.charAt(i);
                if (!visited[i] && s == sound[idx]) {
                    idx++;
                    visited[i] = true;
                    cntTrue++;
                    quack.add(s);
                }
                //하나의 quack을 완성했을 경우
                if (idx == 5) {
                    idx = 0;
                    quack.clear();
                }
            }

            if (!quack.isEmpty()) {
                cnt = 0;
                break;
            } else {
                cnt++;
            }

            if (cntTrue == duck.length()) {
                break;
            }
        }

        if (cnt == 0) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }
    }
}