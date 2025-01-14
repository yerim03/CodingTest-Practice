import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            if (n == -1) {
                break;
            }

            ArrayList<Integer> arrayList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    arrayList.add(i);
                    sum += i;
                }
            }

            if (n == sum) {
                sb.append(n + " = ");
                int size = arrayList.size();
                for (int i = 0; i < size - 1; i++) {
                    sb.append(arrayList.get(i) + " + ");
                }
                sb.append(arrayList.get(size-1) + "\n");
            } else{
                sb.append(n + " is NOT perfect.\n");
            }

            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
    }
}
