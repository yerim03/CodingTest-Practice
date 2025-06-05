package implementation.치킨배달;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, m, result;
    static int cityMin = Integer.MAX_VALUE;
    static int[][] cities;
    static int[] choose;
    static ArrayList<Position> chicken = new ArrayList<>();
    static ArrayList<Position> house = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //도시의 크기
        m = Integer.parseInt(st.nextToken());   //폐업시키지 않을 치킨집의 최대 개수

        cities = new int[n][n];
        choose = new int[m];
        //도시 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cities[i][j] = Integer.parseInt(st.nextToken());
                //치킨집의 위치 정보 저장
                if (cities[i][j] == 2) {
                    chicken.add(new Position(i, j));
                }

                //집의 위치 정보 저장
                if(cities[i][j] == 1)
                    house.add(new Position(i, j));
            }

        }

        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int cnt, int start) {
        //종료조건 : 고른 치킨집의 개수가 m인 경우
        if (cnt == m) {
            result = cityChicken();
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            choose[cnt] = i;
            dfs(cnt + 1, i + 1);
        }
    }

    //도시의 치킨거리의 최솟값 구하는 메서드
    public static int cityChicken() {
        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            int houseMin = houseChicken(house.get(i));
            sum += houseMin;
        }

        cityMin = Math.min(cityMin, sum);
        return cityMin;
    }

    //각 집의 치킨거리를 구하는 메서드
    public static int houseChicken(Position position) {
        int houseMin = Integer.MAX_VALUE;
        int houseX = position.x;
        int houseY = position.y;

        for (int i = 0; i < choose.length; i++) {
            int chickenX = chicken.get(choose[i]).x;
            int chickenY = chicken.get(choose[i]).y;

            int distance = Math.abs((houseX - chickenX)) + Math.abs((houseY - chickenY));
            houseMin = Math.min(houseMin, distance);
        }
        return houseMin;
    }
}
