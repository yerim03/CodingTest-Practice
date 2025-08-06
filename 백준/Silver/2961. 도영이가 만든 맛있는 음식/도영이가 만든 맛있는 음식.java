import java.io.*;
import java.util.StringTokenizer;

/**
 * S2 2961 도영이가 만든 맛있는 음식
 */

public class Main {

    static int n;
    static long result = Long.MAX_VALUE;
    static int[][] ingredients;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        ingredients = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0,  0, 1, 0);
        System.out.println(result);
    }

    /**
     * @param idx 재료의 인덱스
     * @param cnt 요리에 사용된 재료의 개수
     * @param s 신맛
     * @param b 쓴맛
     * */
    public static void dfs(int idx, int cnt, long s, long b) {
        //종료 조건
        if (idx == n) {
            if(cnt >= 1) {
                //신맛과 쓴맛의 차이가 작은 것 찾기
                result = Math.min(result, Math.abs(s - b));
            }
            return;
        }

        //idx번째 재료 포함
        dfs(idx + 1, cnt + 1, s * ingredients[idx][0], b + ingredients[idx][1]);
        //idx번째 재료 미포함
        dfs(idx + 1, cnt, s, b);
    }
}