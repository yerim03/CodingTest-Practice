import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * G4 11559 Puyo Puyo
 */
/*
아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다
같은 색 뿌요가 4개 이상 상하좌우로 연결-> 연결된 같은 색의 뿌요는 없어짐 -> 1연쇄
없어진 후, 위에 다른 뿌요가 있으면 아래로 떨어짐
아래로 떨어지고서 다시 같은 색의  뿌요 4개 이상이면 1연쇄
한번에 여러 그룹이 터지면 1연쇄
연쇄가 몇번 연속으로 일어나는지
* */

class Puyo {
    int x;
    int y;

    public Puyo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int cnt = 0, flag = 0;
    static String[][] array = new String[12][6];
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                array[i][j] = String.valueOf(str.charAt(j));
            }
        }

        while(true) {
            visited = new boolean[12][6];
            flag = 0;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!array[i][j].equals(".") && !visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            if (flag == 1) {    //연쇄가 발생한 경우
                for (int j = 0; j < 6; j++) {
                    for (int i = 11; i >= 0; i--) {
                        if(array[i][j].equals(".")) {
                            movePuyo(i, j);
                        }
                    }
                }
                cnt++;
            } else {    //연쇄가 발생하지 않은 경우 탐색 종료
                break;
            }

        }
        System.out.println(cnt);
    }

    public static void bfs(int x, int y) {
        Queue<Puyo> q = new LinkedList<>();
        ArrayList<Puyo> pos = new ArrayList<>();    //서로 연결된 같은색 뿌요들의 위치

        //시작 뿌요
        q.offer(new Puyo(x, y));
        pos.add(new Puyo(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Puyo poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) {
                    continue;
                }

                if (!visited[nx][ny] && array[nx][ny].equals(array[x][y])) {
                    q.offer(new Puyo(nx, ny));
                    pos.add(new Puyo(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        //연결된 뿌요가 4개 이상이면 연쇄
        if (pos.size() >= 4) {
            removePuyo(pos);
            flag = 1;
        }
    }

    //뿌요 없애기
    public static void removePuyo(ArrayList<Puyo> pos) {
        for (Puyo po : pos) {
            array[po.x][po.y] = ".";
        }
    }

    //연쇄 후 뿌요 떨어뜨리기
    public static void movePuyo(int i, int j) {
        for (int k = i - 1; k >= 0; k--) {
            if (!array[k][j].equals(".")) {
                array[i][j] = array[k][j];
                array[k][j] = ".";
                return;
            }
        }

    }
}