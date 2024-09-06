import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());    //총 바구니 개수
        int m = Integer.parseInt(st.nextToken());    //역순 횟수

        int[] arr = new int[n+1];
        for (int i = 1; i<= n; i++) {
            arr[i] = i;
        }

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            while (i < j) {
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(arr[i] + " ");
        }
        
        bw.flush();
        bw.close();
    }
}