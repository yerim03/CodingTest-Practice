import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] array = new int[12];
    public static int[] operator = new int[4];
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    //수의 개수

        //n개의 수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt((st.nextToken()));
        }

        //연산자 종류별 개수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, array[0]);
        System.out.println(max + "\n" + min);

    }

    public static void dfs(int index, int result) {
        //종료조건
        if (index == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i]--;
                switch (i) {
                    case 0 :
                        dfs(index + 1, result + array[index]);
                        break;
                    case 1 :
                        dfs(index + 1, result - array[index]);
                        break;
                    case 2 :
                        dfs(index + 1, result * array[index]);
                        break;
                    case 3:
                        dfs(index + 1, result / array[index]);
                        break;
                }
                operator[i]++;
            }
        }
    }
}
