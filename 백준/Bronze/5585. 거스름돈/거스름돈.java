import java.io.*;

public class Main {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

         int money = 1000 - Integer.parseInt(br.readLine());    //받아야 할 잔돈
         int[] coins = {500, 100, 50, 10, 5, 1};
         int coin_cnt = 0;

         for (int coin : coins) {
             coin_cnt += money / coin;
             money %= coin;
         }
         
         bw.write(coin_cnt + "\n");

         bw.flush();
         bw.close();
    }
}