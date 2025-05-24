import java.io.*;
import java.util.StringTokenizer;

//같은 수를 여러 번 골라도 된다. -> 방문처리를 할 필요가 없음
public class Main {

    public static int n, m;
    public static boolean[] visited = new boolean[10];
    public static int[] array;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[m];
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i : array) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            array[depth] = i;
            dfs(depth + 1);
        }
    }
}

