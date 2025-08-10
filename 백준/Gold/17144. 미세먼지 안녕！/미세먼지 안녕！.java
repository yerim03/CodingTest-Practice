import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * G4 17144 미세먼지 안녕!
 */

public class Main {

    static int r, c, t, result = 0;
    static int[][] room;
    static ArrayList<Integer> purifierRow = new ArrayList<>();  //공기청정기의 행 위치
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        room = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                //공기청정기의 위치 확인
                if (room[i][j] == -1) {
                    purifierRow.add(i);
                }
            }
        }

        while (t > 0) {
            int[][] array = new int[r][c];
            dust(array); //미세먼지 확산

            //미세먼지 확산 후 상황을 복사
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    room[i][j] = array[i][j];
                }
            }

            clean(array, purifierRow);    //공기청정기 작동
            t--;
        }
        
        //t초가 지난 후 모든 미세먼지의 양 더하기
        for (int[] ints : room) {
            for (int anInt : ints) {
                if(anInt > -1) {
                    result += anInt;
                }
            }
        }
        System.out.println(result);
    }

    //미세먼지 확산
    public static void dust(int[][] array) {

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //미세먼지가 있는 칸이면 확산 시작
                if (room[i][j] > 0) {
                    int cnt = 0;    //확산된 방향의 개수
                    int d = room[i][j] / 5;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (nr < 0 || nc < 0 || nr >= r || nc >= c) {
                            continue;
                        }

                        if (room[nr][nc] != -1) {
                            array[nr][nc] += d;
                            cnt++;
                        }
                    }
                    array[i][j] += (room[i][j] - d * cnt);
                }
            }
        }
    }


    //공기청정기 작동
    public static void clean(int[][] array, ArrayList<Integer> purifierRow) {
        int up = purifierRow.get(0);
        int down = purifierRow.get(1);

        //1단계
        for (int i = 0; i < c - 1; i++) {
            room[up][i + 1] = array[up][i];
            room[down][i + 1] = array[down][i];
        }

        //up 2단계
        for (int i = up; i > 0; i--) {
            room[i - 1][c - 1] = array[i][c - 1];
        }

        //down 2단계
        for (int i = down; i < r - 1; i++) {
            room[i + 1][c - 1] = array[i][c - 1];
        }

        //3단계
        for (int i = c - 1; i > 0; i--) {
            room[0][i - 1] = array[0][i];
            room[r - 1][i - 1] = array[r - 1][i];
        }

        //up 4단계
        for (int i = 0; i < up; i++) {
            room[i + 1][0] = array[i][0];
        }

        //down 4단계
        for (int i = r - 1; i > down; i--) {
            room[i - 1][0] = array[i][0];
        }

        room[up][0] = room[down][0] = -1;
    }
}