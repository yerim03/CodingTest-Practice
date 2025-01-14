import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());


        StringBuilder sb_a = new StringBuilder(st.nextToken());
        StringBuilder sb_b = new StringBuilder(st.nextToken());

        int a = Integer.parseInt(sb_a.reverse().toString());
        int b = Integer.parseInt(sb_b.reverse().toString());

        bw.write((a > b ? a : b) + "\n");
        bw.flush();
        bw.close();
    }
}