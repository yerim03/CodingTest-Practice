import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    //문제의 수
        String str = br.readLine();

        int r_count = 0;    //R 개수
        int b_count = 0;    //B 개수

        if (str.charAt(0) == 'R') {
            r_count++;
        } else {
            b_count++;
        }

        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == 'R') {
                    r_count++;
                } else {
                    b_count++;
                }
            }
        }

        int result = Math.min(r_count, b_count) + 1;
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}