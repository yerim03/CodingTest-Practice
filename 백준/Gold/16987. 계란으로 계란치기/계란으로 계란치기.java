import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, max = 0;
    static int[][] eggs;
    static boolean[] broken = new boolean[8];

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

        //손에 든 계란이 깨졌거나, 깨지지 않은 다른 계란이 없는 경우
        if (broken[hand] || cnt == n - 1) {
            eggBreak(hand + 1, cnt);
            return;
        }

        int temp = cnt;
        for (int i = 0; i < n; i++) {
            if (hand == i) {
                continue;
            }

            if (!broken[i]) {
                hitEgg(hand, i);    //두 계란을 치기
                if (eggs[hand][0] <= 0) {
                    cnt++;
                    broken[hand] = true;
                }
                if (eggs[i][0] <= 0) {
                    cnt++;
                    broken[i] = true;
                }
                eggBreak(hand + 1, cnt);
                restoreEgg(hand, i);//원래대로
                cnt = temp;
            }
        }
    }

    //두 계란 치기
    private static void hitEgg(int hand, int i) {
        //계란의 내구도 -= 상대 계란의 무게
        eggs[hand][0] -= eggs[i][1];
        eggs[i][0] -= eggs[hand][1];
    }
    
    private static void restoreEgg(int hand, int i) {
        eggs[hand][0] += eggs[i][1];
        eggs[i][0] += eggs[hand][1];
        broken[hand] = false;
        broken[i] = false;
    }
}