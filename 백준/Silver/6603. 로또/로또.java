import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static int k;
    public static int[] numbers = new int[13];
    public static int[] result = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }
            else {
                for (int i = 0; i < k; i++) {
                    numbers[i] = Integer.parseInt(st.nextToken());
                }
               selectNumbers(0, 0);
                System.out.println();
            }
        }
    }

    public static void selectNumbers(int cnt, int start) {
        //종료 조건
        if (cnt == 6) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            result[cnt] = numbers[i];
            selectNumbers(cnt + 1, i + 1);
        }
    }
}