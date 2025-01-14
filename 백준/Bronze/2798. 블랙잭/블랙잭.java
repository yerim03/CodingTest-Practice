import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //총 카드 수
        int m = Integer.parseInt(st.nextToken());   //3장의 합의 최대값

        //m을 넘지 않으면서 m에 최대한 가까운 카드 3장의 합 구하기
        String str = br.readLine();
        int[] cards = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();

//        int[] cards = new int[n];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            cards[i] = Integer.parseInt(st.nextToken());
//        }

        bw.write(blackJack(cards, n, m) + "\n");
        bw.flush();
        bw.close();
    }

    public static int blackJack(int[] cards, int n, int m) {
        int max = 0;    //카드 3장의 합
        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1; j < n-1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum == m) { //합이 m과 같을 경우
                        return sum;
                    } else if (sum < m && sum > max) {  //합이 m보다 작고, max보다 클 경우
                        max = sum;
                    }
                }
            }
        }
        return max;
    }
}
