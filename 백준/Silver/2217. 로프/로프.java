import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    //로프 개수

        int[] ropes = new int[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);
        int result = 0;
        for (int i = 0; i < n; i++) {
            int weight = ropes[i] * (n - i);
            result = Math.max(result, weight);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}