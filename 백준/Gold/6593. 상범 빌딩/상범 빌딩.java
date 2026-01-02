import java.io.*;
import java.util.*;

/**
 * G5 6593 상범빌딩
 */

public class Main {

    static int l, r, c;
    static String[][][] building;
    static int[][][] time;
    static int[] dx= {1, -1, 0, 0, 0, 0};
    static int[] dy= {0, 0, 1, -1, 0, 0};
    static int[] dz= {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());   //층수
            r = Integer.parseInt(st.nextToken());   //한 층의 행 개수
            c = Integer.parseInt(st.nextToken());   //한 층의 열 개수

            //입력 끝 조건
            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            building = new String[l][r][c];
            time = new int[l][r][c];
            int x = 0, y = 0, z = 0;

            for (int i = 0; i < l; i++) {
                for(int j = 0; j < r; j++) {
                    String[] str = br.readLine().split("");
                    for (int k = 0; k < c; k++) {
                        building[i][j][k] = str[k];
                        if(str[k].equals("S")) {
                            x = i;
                            y = j;
                            z = k;
                        }
                    }
                }
                String space = br.readLine();
            }
            int result = findExit(x, y, z);
            if(result != 0) {
                System.out.println("Escaped in " + result + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
    }

    //bfs
    public static int findExit(int start_x, int start_y, int start_z) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{start_x, start_y, start_z});

        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int z = poll[2];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                //범위를 벗어나는 경우
                if(nx < 0 || ny < 0 || nz < 0 || nx >= l || ny >= r|| nz >= c) {
                    continue;
                }

                if(building[nx][ny][nz].equals("#") || time[nx][ny][nz] != 0) {
                    continue;
                }

                if(building[nx][ny][nz].equals(".")) {
                    q.offer(new int[]{nx, ny, nz});
                    time[nx][ny][nz] = time[x][y][z] + 1;
                } else if(building[nx][ny][nz].equals("E")) {
                    time[nx][ny][nz] = time[x][y][z] + 1;
                    return time[nx][ny][nz];
                }
            }
        }
        return 0;
    }
}