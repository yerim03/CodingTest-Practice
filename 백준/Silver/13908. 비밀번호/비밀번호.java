import java.io.*;
import java.util.StringTokenizer;

/**
 *  S2 13908 비밀번호
 */

public class Main {

    static int n, m, total = 0;
    static int[] knownNum = new int[7]; //선견지명으로 알게된 숫자들
    static int[] used = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //비밀번호의 길이
        m = Integer.parseInt(st.nextToken());   //선견지명으로 알게된 비밀번호 개수

        if(m != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                knownNum[i] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(0);
        System.out.println(total);
    }

    public static void dfs(int len) {
        if (len == n) {
            //선견지명으로 알게된 숫자가 모두 포함되어 있는지 확인
            for(int i = 0; i < m; i++) {
                if (used[knownNum[i]] == 0) {
                    return;
                }
            }
            total++;
            return;
        }

        for (int i = 0; i <= 9; i++) {
            used[i]++;
            dfs(len + 1);
            used[i]--;
        }
    }
}