import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, max = 0;
    static int[][] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    //계란의 수

        eggs = new int[n][2];
        //계란의 내구도와 무게 입력받기(왼 -> 오)
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());  //내구도
            eggs[i][1] = Integer.parseInt(st.nextToken());  //무게
        }

        eggBreak(0, 0);
        System.out.println(max);
    }


    /**
     * @param hand 손에 들고 있는 계란의 인덱스
     * @param cnt  깬 계란의 개수
     */
    public static void eggBreak(int hand, int cnt) {
        //종료 - 가장 최근의 든 계란이 가장 오른쪽 계란일 경우
        if (hand == n) {
            max = Math.max(max, cnt);
            return;
        }

        if (eggs[hand][0] <= 0) {   //손에 든 계란이 깨진 경우 -> 내려놓고 다음 계란을 든다
            eggBreak(hand + 1, cnt);
        } else {                    //손에 든 계란이 깨지지 않은 경우 -> 계란치기 실행
            boolean flag = false;   //계란치기를 한번이라도 했는지 안했는지
            for (int i = 0; i < n; i++) {
                if (hand == i || eggs[i][0] <= 0) { //
                    continue;
                }
                flag = true;
                eggs[hand][0] -= eggs[i][1];
                eggs[i][0] -= eggs[hand][1];
                eggBreak(hand + 1, cnt + (eggs[hand][0] <= 0 ? 1 : 0) + (eggs[i][0] <= 0 ? 1 : 0));
                eggs[hand][0] += eggs[i][1];
                eggs[i][0] += eggs[hand][1];
            }

            if (!flag) {    //깨지지 않은 계란이 없어서 한 번도 치지 못한 경우
                eggBreak(hand + 1, cnt);
            }
        }
    }
}