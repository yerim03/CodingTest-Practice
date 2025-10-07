import java.io.*;
import java.util.*;

/**
 * S5 그룹 단어 체커
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int[] alpha = new int[26];
            boolean flag = false;

            alpha[str.charAt(0) - 'a']++;
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) == str.charAt(j - 1)) {
                    continue;
                }

                if(alpha[str.charAt(j) - 'a'] >= 1) flag = true;

                alpha[str.charAt(j) - 'a']++;
            }
            if(!flag) cnt++;
        }

        System.out.println(cnt);
    }
}