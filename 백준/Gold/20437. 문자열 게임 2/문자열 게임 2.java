import java.io.*;

/**
 * G5 20437 문자열게임2
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            //k가 1인 경우는 따로 처리
            if (k == 1) {
                sb.append(1 + " " + 1 + " \n");
                t--;
                continue;
            }

            //문자열에서 알파벳별로 개수를 세서 저장
            int[] alphaCnt = new int[26];
            for (int i = 0; i < w.length(); i++) {
                alphaCnt[w.charAt(i) - 'a']++;
            }

            int shortestStr = Integer.MAX_VALUE;    //특정문자 k개 포함하는 가장 짦은 문자열의 길이
            int longestStr = Integer.MIN_VALUE;     //특정문자 k개 포함 + 맨앞,뒤문자가 같은 가장 긴 문자열의 길이


            for (int i = 0; i < w.length() - 1; i++) {
                if (alphaCnt[w.charAt(i) - 'a'] < k)    continue;   //해당 알파벳의 개수가 k보다 작으면 탐색하지 않는다.
                
                int cnt = 1;
                for (int j = i + 1; j < w.length(); j++) {
                    if (w.charAt(i) == w.charAt(j)) {
                        cnt++;
                        if (cnt == k) {
                            shortestStr = Math.min(shortestStr, j - i + 1);
                            longestStr = Math.max(longestStr, j - i + 1);
                            break;
                        }
                    }
                }
            }

            if (shortestStr == Integer.MAX_VALUE || longestStr == Integer.MIN_VALUE) {
                sb.append(-1 + "\n");
            } else {
                sb.append(shortestStr + " " + longestStr + "\n");
            }
            t--;
        }
        System.out.println(sb);
    }
}