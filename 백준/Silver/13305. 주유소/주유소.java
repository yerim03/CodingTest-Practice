import java.io.*;
import java.util.StringTokenizer;

/**
 * S3 13305 주유소
 */


public class Main {

    static int n;
    static long result = 0;
    static int[] length;
    static int[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //도시의 개수

        length = new int[n - 1];
        price = new int[n];
        //도로의 길이 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }

        //주유소 리터당 가격
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        findMinPrice();
        System.out.println(result);
    }

    public static void findMinPrice() {
        long minPrice = price[0];

        result = minPrice * length[0];
        for (int i = 1; i < n - 1; i++) {
            if (minPrice > price[i]) {
                minPrice = price[i];
            }
            result += minPrice * length[i];
        }
    }

}