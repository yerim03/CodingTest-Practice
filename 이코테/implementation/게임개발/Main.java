package implementation.게임개발;


import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());   //캐릭터 x 좌표
        int y = Integer.parseInt(st.nextToken());   //캐릭터 y 좌표
        int direction = Integer.parseInt(st.nextToken());


        //북, 동, 남, 서 방향
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] map = new int[50][50];  //맵 정보 - 0: 육지, 1: 바다
        boolean[][] visited_map = new boolean[50][50];  //가본 칸인지 아닌지 체크

        //맵 정보 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }


        int result = 1; //캐릭터가 방문한 칸의 수
        int turn_cnt = 0;   //동서남북 모두 이동가능여부를 확인했는지 회전 횟수
        visited_map[x][y] = true;   //현재 좌표 위치는 방문 처리
        while (true) {
            //먼저 왼쪽 방향으로 회전
            direction--;
            if (direction == -1) {
                direction = 3;
            }

            //왼쪽 방향 좌표
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (map[nx][ny] == 0 && visited_map[nx][ny] == false) { //가보지 않은 칸일 경우
                //왼쪽 방향으로 한칸 이동
                x = nx;
                y = ny;
                result++;
                turn_cnt = 0;
                visited_map[x][y] = true;   //방문 처리
                continue;
            } else {                 //가본 칸일 경우
                //회전 횟수만 증가
                turn_cnt++;
            }

            if (turn_cnt == 4) {    //네 방향 모두 이미 가본 칸이거나 바다일 경우
                //현재 위치에서 뒤로 한칸 이동
                nx = x - dx[direction];
                ny = y - dy[direction];

                //그 중에서
                if (map[nx][ny] == 0) {    //뒤로 갈 수 있는 경우
                    //뒤로 한칸 이동
                    x = nx;
                    y = ny;
                } else {    //바다라 뒤로 갈 수 없는 경우
                    break;
                }
                turn_cnt = 0;
            }
        }

        System.out.println(result);
    }
}