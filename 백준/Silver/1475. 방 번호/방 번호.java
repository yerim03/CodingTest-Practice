import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[10];
        while(n > 0) {
            array[n % 10]++;
            n /= 10;
        }

        int mid = (array[6] + array[9] + 1) / 2;
        array[6] = array[9] = mid;
        int maxValue = 0;
        for (int i = 0; i < 10; i++) {
            maxValue = Math.max(maxValue, array[i]);
        }
        System.out.println(maxValue);
    }
}