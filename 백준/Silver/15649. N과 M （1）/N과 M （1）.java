import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> aList = new ArrayList<>();
        dfs(0, aList);
    }

    public static void dfs(int count, ArrayList<Integer> aList) {
        //종료조건 : if count == m 이면 재귀 종료
        if (count == m) {
            for (Integer integer : aList) {
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }

        //재귀 호출
        for (int i = 1; i <= n; i++) {
            //수열에 중복되는 수가 없을 경우 해당 수를 aList에 넣고 재귀호출
            if (!aList.contains(i)) {
                aList.add(i);
                dfs(count + 1, aList);
                aList.remove(count);
            }
        }
    }
}