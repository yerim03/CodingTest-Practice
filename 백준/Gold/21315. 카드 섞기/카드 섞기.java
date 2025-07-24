import java.io.*;
import java.util.*;

/**
 * G5 21315 카드섞기
 */

public class Main {

    static int n;
    static int[] goal;
    static int[] cards;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        goal = new int[n];
        cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            goal[i] = Integer.parseInt(st.nextToken());
            cards[i] = i + 1;
        }

        card();
        System.out.println(sb);
    }

    public static void card() {
        //k의 범위 구하기 -> 2^k < n
        int range = 0;
        for (int i = 1; i <= 9; i++) {
            if (Math.pow(2, i) > n) {
                range = i - 1;
                break;
            }
        }
        for (int i = 1; Math.pow(2, i) < n; i++) {
            for (int j = 1; Math.pow(2, j) < n; j++) {
                int[] temp = cards.clone();

                shuffle(i, temp);   //첫번째 섞기
                shuffle(j, temp);   //두번째 섞기

                //두번째 섞기 결과와 result 배열이 같은지 확인
                if (check(goal, temp)) {
                    sb.append(i + " " + j);
                    return;
                }
            }
        }
    }

    public static void shuffle(int k, int[] temp) {
        int beforeCnt = n;   //직전 단계에서 맨 위에 올린 카드 개수
        int cnt = 0;
        for (int i = 1; i <= k + 1; i++) {
            cnt = (int) Math.pow(2, k - i + 1); //위로 올릴 카드의 개수


            ArrayList<Integer> result = new ArrayList<>(); //카드 섞기 결과

            //cnt 개의 카드를 맨 위로 올리기
            for (int j = beforeCnt - cnt; j < beforeCnt; j++) {
                result.add(temp[j]);
                temp[j] = 0;
            }

            //나머지 카드들
            for (int j = 0; j < n; j++) {
                if (temp[j] != 0) {
                    result.add(temp[j]);
                }
                temp[j] = result.get(j);
            }
            result.clear();
            beforeCnt = cnt;
        }
    }

    public static boolean check(int[] goal, int[] temp) {
        for (int i = 0; i < n; i++) {
            if (goal[i] != temp[i]) {
                return false;
            }
        }
        return true;
    }
}