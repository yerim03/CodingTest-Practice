import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min_value = 10001;
        for (int i = m; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }

            if (count == 2) {
                sum += i;
                min_value = Math.min(min_value, i);
            }
        }

        if (sum == 0) {
            bw.write(-1 + "\n");
        } else {
            bw.write(sum + "\n" + min_value);
        }
        bw.flush();
        bw.close();
    }
}