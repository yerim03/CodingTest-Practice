import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int result = 0;
    static String[][] students = new String[5][5];
    static boolean visited[][] = new boolean[5][5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                students[i][j] = String.valueOf(str.charAt(j));

            }
        }

        //이다솜-S, 임도연-Y
        dfs(0, 0, 0);
        System.out.println(result);
    }

    /*
     * 1. 7명의 조합 선택 -> 2차원을 1차원으로 바꿔서
     * 2. S가 4명 이상인 조합 선택
     * 3. 그 중에서 모든 학생이 서로 인접한지 확인*/

    public static void dfs(int cnt, int cntS, int start) {
        if (cnt == 7) {
            if (cntS >= 4) {
                //7명이 서로 인접해 있는지 체크
                if (checked()) {
                    result++;
                }
                return;
            }
        }

        for (int i = start; i < 25;  i++) {
            int x = i / 5;
            int y = i % 5;

            visited[x][y] = true;
            if (students[x][y].equals("S")) {
                dfs(cnt + 1, cntS + 1, i + 1);
            } else {
                dfs(cnt + 1, cntS, i + 1);
            }
            visited[x][y] = false;
        }
    }


    public static boolean checked() {
        //가장 첫 번째 학생의 위치 찾아서 bfs 시작
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) {
                    return bfs(i, j);
                }
            }
        }
        return false;
    }

    public static boolean bfs(int i, int j) {
        Queue<Position> q = new LinkedList<>();
        boolean v2[][] = new boolean[5][5];
        q.offer(new Position(i, j));    //첫번째 학생을 큐에 삽입
        v2[i][j] = true;
        int cnt = 1;

        //시작
        while (!q.isEmpty()) {
            Position poll = q.poll();
            int x = poll.x;
            int y = poll.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                //범위를 벗어나는 경우
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                    continue;
                }

                if (visited[nx][ny] && !v2[nx][ny]) {
                    cnt++;
                    q.offer(new Position(nx, ny));
                    v2[nx][ny] = true;    //확인한 학생 true 처리
                }
            }
        }
        return cnt == 7 ? true : false;
    }
}