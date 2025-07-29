import java.io.*;
import java.sql.SQLOutput;

/**
 *  G5 16719 ZOAC
 */

public class Main {

    static String str;
    static boolean[] visited = new boolean[100];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        show(0, str.length() - 1);
        System.out.println(sb);
    }

    public static void show(int start, int end) {
        if (start > end) {
            return;
        }
        char ch = str.charAt(start);
        int idx = start;
        //해당 범위에서 사전 순으로 가장 앞에 오는 문자를 찾는다
        for (int i = start; i <= end; i++) {
            if (ch > str.charAt(i)) {
                ch = str.charAt(i);
                idx = i;
            }
        }

        visited[idx] = true;    //방문 처리
        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) {
                sb.append(str.charAt(i));
            }
        }
        sb.append("\n");

        //현재 문자의 오른족
        show(idx + 1, end);
        //현재 문자의 왼쪽
        show(start, idx - 1);
    }
}