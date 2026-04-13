import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(array);
        int cnt = 0;
        int left = 0, right = n - 1;
        while(left < right) {
            int sum = array[left] + array[right];
            if(sum == x){
                cnt++;
                left++;
                right--;
            } else if (sum > x) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(cnt);
    }
}