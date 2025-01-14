import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int num = 2;
        while (n > 1) {
            if (n % num == 0) {
                sb.append(num + "\n");
                n /= num;
            } else {
                num++;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
