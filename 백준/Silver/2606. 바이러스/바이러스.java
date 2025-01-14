import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, v;
    public static boolean[] visited;
    public static ArrayList<Integer>[] graph;   //ArrayList 2차원 배열 사용

    public static void checkVirus(int start) {
        visited[start] = true;

        for (int i : graph[start]) {
            if (!visited[i]) {
                checkVirus(i);
            }
        }
    }

     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st;
         int n = Integer.parseInt(br.readLine());   //컴퓨터 수
         int m = Integer.parseInt(br.readLine());   //연결되어 있는컴퓨터 쌍의 수


         graph = new ArrayList[n + 1];
         visited = new boolean[n + 1];
         for (int i = 0; i <= n; i++) {
             graph[i] = new ArrayList<>();
             visited[i] = false;
         }

         //번호쌍 입력받기
         for (int i = 0; i < m; i++) {
             st = new StringTokenizer(br.readLine());
             int x = Integer.parseInt(st.nextToken());
             int y = Integer.parseInt(st.nextToken());
             graph[x].add(y);
             graph[y].add(x); //양방향
         }

         checkVirus(1);

         int result = 0;
         //바이러스에 감염된 컴퓨터 수 구하기
         //1번 컴퓨터 제외
         for (int i = 2; i < visited.length; i++) {
             if (visited[i]) {
                 result++;
             }
         }

         bw.write(String.valueOf(result));
         bw.flush();
         bw.close();
    }
}