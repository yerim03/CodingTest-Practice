import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * G4 15961 회전 초밥
 */

public class Main {

    static int n, d, k, c;
    static int sushiCnt = 0, result = 0;
    static int[] sushi;
    static int[] eatSushi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //접시의 수
        d = Integer.parseInt(st.nextToken());   //초밥 가짓수
        k = Integer.parseInt(st.nextToken());   //연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken());   //쿠폰 번호

        sushi = new int[n];
        eatSushi = new int[d + 1];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }


        //시작 - 0번째부터 k개의 초밥 선택
        for (int j = 0; j < k; j++) {
            if(eatSushi[sushi[j]] == 0) {   //초밥 종류 개수 세기
                sushiCnt++;
            }
            eatSushi[sushi[j]]++;
        }

        result = sushiCnt + (eatSushi[c] == 0 ? 1 : 0); //쿠폰 초밥

        for (int i = 1; i < n; i++) {
            //맨 앞의 초밥(i-1번 째) 빼기
            eatSushi[sushi[i - 1]]--;
            if(eatSushi[sushi[i - 1]] == 0) sushiCnt--; //

            //맨 뒤의 초밥((i+k-1)%n번 째) 더하기
            if(eatSushi[sushi[(i + k - 1) % n]] == 0) sushiCnt++;
            eatSushi[sushi[(i + k - 1) % n]]++;

            result = Math.max(result, sushiCnt + (eatSushi[c] == 0 ? 1 : 0));    //최대값 비교
        }
        System.out.println(result);
    }
}