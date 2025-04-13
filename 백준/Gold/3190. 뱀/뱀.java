import java.io.*;
import java.util.*;

class Position{
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Spin {
    int time;
    String direction;

    public Spin(int time, String direction) {
        this.time = time;
        this.direction = direction;
    }
}


public class Main {
    public static int n, k, l;
    public static int[][] board;
    public static String[] directions = new String[101];

    //동, 북, 서, 남
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};

    public static Queue<Position> snake = new LinkedList<>();   //뱀이 위치하고 있는 위치 정보
    public static Queue<Spin> spin = new LinkedList<>();    //뱀의 방향 전환 정보

    public static int move(int x, int y) {
        board[x][y] = 2;    //뱀의 시작
        int dir = 0;    //뱀의 이동 방향. 처음엔 동쪽
        int time = 0;
        snake.offer(new Position(x, y));    //뱀의 첫번째 위치를 큐에 삽입

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            time++;
            //뱀이 벽 또는 자기 자신의 몸과 부딪히면 게임 종료
            if(nx < 1 || ny < 1 || nx > n || ny > n) {
                break;
            }
            if (board[nx][ny] == 2) {
                break;
            }

            if (board[nx][ny] == 1) {   //이동하는 칸에 사과가 있을 경우
                board[nx][ny] = 2;  //board에서 해당 칸을 2로 변경
                snake.offer(new Position(nx, ny));  //큐에 머리부분 삽입
            } else if (board[nx][ny] == 0) {    //이동하는 칸에 사과가 없을 경우
                //2. board에서 꼬리부분을 0으로 변경
                board[nx][ny] = 2;              //board에서 머리부분 값을 2로 변경
                snake.offer(new Position(nx, ny));  //큐에 머리부분 삽입
                Position tail = snake.poll();   //큐에서 꼬리 제거
                board[tail.x][tail.y] = 0;  //board에서 꼬리부분의 값을 0로 변경
            }

            //다음 위치를 뱀의 머리 좌표로 변경
            x = nx;
            y = ny;

            //뱀의 이동 방향을 바꾸는 지 확인
            if (!spin.isEmpty()) {
                if (time == spin.peek().time) {
                    Spin s = spin.poll();
                    if (s.direction.equals("L")) {
                        dir = (dir == 3) ? 0 : dir + 1;
                    }
                    if (s.direction.equals("D")) {
                        dir = (dir == 0) ? 3 : dir - 1;
                    }
                }
            }
        }
        return time;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    //보드의 크기
        k = Integer.parseInt(br.readLine());    //사과의 개수

        board = new int[n + 1][n + 1];
        //사과 위치 입력받기
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }

        //방향 회전 정보
        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());   //게임 시작 시간으로부터 x초
            String dir = st.nextToken();
            spin.offer(new Spin(s, dir));
        }

        System.out.println(move(1, 1));
    }
}