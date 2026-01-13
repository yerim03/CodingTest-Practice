import java.io.*;
import java.util.*;

/**
 * G5 2467 용액
 */

public class Main {

    static class Cctv {
        int x;  //cctv x좌표
        int y;  //cctv y좌표
        int number; //cctv 번호

        public Cctv(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }

    static int n, m, answer = 0;
    static int[][] office;
    static ArrayList<Cctv> cctvInfo = new ArrayList<>();
    //순서대로 하, 상, 우, 좌
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    //순서대로 빈칸, cctv1, cctv2, cctv3, cctv4, cctv5의 방향 경우의 수
    static int[][][] allDirections = {{},
                                    {{0}, {1}, {2}, {3}},
                                    {{0, 1}, {2, 3}},
                                    {{0, 2}, {0, 3}, {1, 2}, {1, 3}},
                                    {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}},
                                    {{0, 1, 2, 3}}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        office = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if(office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvInfo.add(new Cctv(i, j, office[i][j]));
                } else if(office[i][j] == 0) {
                    answer++;
                }
            }
        }
        
        checkMonitoringArea(0, office);
        System.out.println(answer);
    }

    /**
     * cctv 감시 가능 영역을 탐색하는 함수
     * @param cctvCnt   cctvInfo에서 현재 cctv의 인덱스
     * @param office    cctv 감시 가능 영역을 표시한 현재 사무실 상태
     * */
    public static void checkMonitoringArea(int cctvCnt, int[][] office) {
        //모든 cctv를 확인했으면 감시불가능 영역 개수를 구해서 최소값 업데이트
        if (cctvCnt == cctvInfo.size()) {
            int cnt = countMonitoringArea(office);
            answer = Math.min(answer, cnt);
            return;
        }

        //현재 cctv로 감시할 수 있는 영역 구하기
        Cctv curCctv = cctvInfo.get(cctvCnt);
        int[][] dir = allDirections[curCctv.number];    //현재 cctv로 감시할 수 있는 경우의 수가 담긴 배열

        for(int i = 0; i < dir.length; i++) {
            int[][] copy = copiedOffice(office);    //사무실 상태를 복사
            for(int j = 0; j < dir[i].length; j++) {
                int row = curCctv.x;
                int col = curCctv.y;

                int curDir = dir[i][j]; //현재 이동할 방향

                while(true) {
                    int nx = row + dx[curDir];
                    int ny = col + dy[curDir];

                    //범위를 벗어난 경우
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        break;
                    }
                    //벽인 경우
                    if(copy[nx][ny] == 6) {
                        break;
                    }

                    //감시 가능 영역이면 -1 표시
                    row = nx;
                    col = ny;
                    copy[nx][ny] = -1;
                }

            }
            checkMonitoringArea(cctvCnt + 1, copy);
        }
    }
    
    /**
     * 사무실 배열을 복사하는 함수 
     * */
    public static int[][] copiedOffice(int[][] office) {
        int[][] copy = new int[n][m];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = office[i][j];
            }
        }
        return copy;
    }

    /**
     * 사각지대 영역 개수를 구하는 함수
     * @param office_done   cctv로 감시할 수 있는 영역 표시를 완료한 배열
     * */
    public static int countMonitoringArea(int[][] office_done) {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(office_done[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}