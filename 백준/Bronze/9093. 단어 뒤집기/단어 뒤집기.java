import java.io.*;
import java.util.StringTokenizer;

public class Main {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

         int t = Integer.parseInt(br.readLine());

         for (int i = 0; i < t; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine());

             while (st.countTokens() != 0) {
                 StringBuilder sb = new StringBuilder(st.nextToken());
                 bw.write(sb.reverse() + " ");
             }
             bw.write("\n");
         }

         bw.flush();
         bw.close();
    }
}