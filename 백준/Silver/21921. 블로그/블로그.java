import java.io.*;
import java.util.StringTokenizer;

/**
 *  S3 21921 블로그
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //블로그를 시작하고 지난 일수
        int x = Integer.parseInt(st.nextToken());   //최대 방문자수를 구하는 기간

        int[] days = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }
        
        int visited = 0;
        //첫번째 X일 동안의 방문자 수
        for (int i = 0; i < x; i++) {
            visited += days[i];
        }

        int maxCnt = visited; //가장 많이 들어온 방문자 수
        int periodCnt = 1;  //기간의 개수
        for (int i = x; i < n; i++) {
            visited -= days[i - x];
            visited += days[i];

            if (visited > maxCnt) {
                maxCnt = visited;
                periodCnt = 1;
            } else if (visited == maxCnt) {
                periodCnt++;
            }
        }
        
        if (maxCnt == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxCnt + "\n" + periodCnt);
        }
    }
}