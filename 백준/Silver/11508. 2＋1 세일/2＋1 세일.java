import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    //유제품 수

        Integer[] products = new Integer[n];    //유제품 가격
        for (int i = 0; i < n; i++) {
            products[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(products, Collections.reverseOrder()); //오름차순 정렬

        /*
        * 값이 가장 큰 수부터 3개씩 고른 후
        * 그 중에서 가장 값이 작은 것 빼고 나머지 두 값만 지불한다.
        * */

        int result = 0;
        for (int i = 0; i < n; i++) {
            if ((i % 3) != 2) {
                result += products[i];
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}