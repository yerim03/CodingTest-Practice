import java.io.*;
import java.util.*;

/**
 * S4 2164 카드2
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    //카드 개수

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while(true) {
            if(q.size() == 1) {
                break;
            }

            //제일 위에 있는 카드 버림
            q.poll();

            //두번째로 위에 있는 카드는 제일 아래로 옮김
            int temp = q.poll();
            q.offer(temp);
        }

        System.out.println(q.poll());
    }
}