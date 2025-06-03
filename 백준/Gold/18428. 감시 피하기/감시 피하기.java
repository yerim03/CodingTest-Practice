import java.io.*;
import java.util.*;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int n;
    static String[][] map;
    static ArrayList<Position> teachers = new ArrayList<>();
    static String result = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new String[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken();
                //선생님의 위치 정보 저장
                if (map[i][j].equals("T")) {
                    teachers.add(new Position(i, j));
                }
            }

        }
        dfs(0);
        System.out.println(result);
    }

    public static void dfs (int walls){
        //종료조건
        if (walls == 3) {
            //모든 학생이 감시를 피할 수 있는지 확인
            findStudents();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("X")) {
                    map[i][j] = "O";
                    dfs(walls + 1);
                    map[i][j] = "X";
                }
            }
        }
    }

    public static void findStudents() {
        int cnt = 0;
        for (Position teacher : teachers) {
            if (find(teacher)) {
                cnt++;
            }
        }
        //모든 선생님이 학생을 발견하지 못했다면 YES
        if (cnt == teachers.size()) {
            result = "YES";
        }
    }


    public static boolean find (Position teacher) {
        int x = teacher.x;
        int y = teacher.y;

        //상
        for (int i = x; i >= 0; i--) {
            if (map[i][y].equals("S"))  return false;   //학생 발견-> 감시를 피하지 못함

            if (map[i][y].equals("O"))  break;  //장애물 발견-> 감시를 피할 수 있음
        }

        //하
        for (int i = x; i < n; i++) {
            if (map[i][y].equals("S"))  return false;

            if (map[i][y].equals("O"))  break;
        }

        //좌
        for (int i = y; i >= 0; i--) {
            if (map[x][i].equals("S"))  return false;

            if (map[x][i].equals("O"))  break;
        }

        //우
        for (int i = y; i < n; i++) {
            if (map[x][i].equals("S")) return false;

            if (map[x][i].equals("O")) break;
        }
        return true;
    }
}