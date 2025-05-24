import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;
    public static boolean[] visited = new boolean[10];
    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[m];
        dfs(0, 1);
    }

    public static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[depth] = i;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}

