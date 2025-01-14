import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] times = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        int answer = 0;
        for(int i = 0; i < n; i++) {
            int p = 0;
            for (int j = 0; j <= i; j++) {
                p += times[j];
            }
            answer += p;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}