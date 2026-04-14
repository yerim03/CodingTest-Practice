import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        while(!q.isEmpty()) {
            for (int i = 1; i <= k - 1; i++) {
                int x = q.poll();
                q.add(x);
            }
            sb.append(q.poll());
            if(!q.isEmpty()) sb.append(", ");
        }
        sb.append(">");


        System.out.println(sb);
    }
}