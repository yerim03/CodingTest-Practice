import java.io.*;
import java.util.StringTokenizer;

/**
 * 15652번 N과 M(4)
 * 1 ~ N 까지 자연수 중에서 M개를 고른 수열
 * 같은 수 중복 가능
 * 비내림차순(A1 <= A2 <= ... A(M-1) <= AM)
 * */
public class Main {

    static int n, m;
    static int[] array;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[m];
        dfs(0, 1);
        System.out.println(sb);
    }

    public static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i : array) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            array[depth] = i;
            dfs(depth+1, i);
        }
    }
}