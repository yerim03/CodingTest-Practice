import java.io.*;
import java.util.*;

/**
 * B2 1978 소수찾기
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(isPrimeNumber(x)) answer++;
        }
        System.out.println(answer);
    }

    public static boolean isPrimeNumber(int x) {
        if(x == 1) return false;    //1

        for (int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0) return false;    //소수가 아님
        }
        return true;    //소수임
    }
}