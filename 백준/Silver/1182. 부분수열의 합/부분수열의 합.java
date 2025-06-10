import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int n, s, result = 0;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0, 0);
        System.out.println(result);
    }

    /**
     * @param size 부분수열의 크기(부분수열 원소의 개수)
     * @param sum 부분수열 원소들의 합
     * */

    public static void dfs(int depth, int size, int sum) {
        if (depth == n) {
            //수열의 합을 구해서 s와 동일한지 확인
            if (size > 0 && sum == s) {
                result++;
            }
            return;
        }
        dfs(depth + 1, size + 1, sum + numbers[depth]);
        dfs(depth + 1, size, sum);
    }
}