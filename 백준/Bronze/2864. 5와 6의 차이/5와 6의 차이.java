import java.io.*;
import java.util.StringTokenizer;

public class Main {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st = new StringTokenizer(br.readLine());

         String a = st.nextToken();
         String b = st.nextToken();

         //최솟값: 숫자 5를 5로 보고, 숫자 6을 5로 잘못 볼 경우
         //최댓값: 숫자 5를 6으로 잘못 보고, 숫자 6을 6으로 볼 경우
         int min = Integer.parseInt(a.replace('6', '5')) + Integer.parseInt(b.replace('6', '5'));
         int max = Integer.parseInt(a.replace('5', '6')) + Integer.parseInt(b.replace('5', '6'));

         bw.write(min + " " + max + "\n");

         bw.flush();
         bw.close();
    }
}