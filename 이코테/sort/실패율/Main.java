package sort.실패율;

import java.io.*;
import java.util.*;

/*
실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
전체 스테이지 수 = n
n+1은 마지막 스테이지(n 스테이지)까지 클리어한 사용자
실패율을 내림차순 정렬, 실패율이 같다면 스테이지번호 오름차순 정렬
*/
class Solution {
    public int[] solution(int N, int[] stages) {
        double[][] failRate = new double[N][2]; //스테이지 번호와 실패율을 담는 배열
        int[] result = new int[N];

        int totalPlayers = stages.length;     //현재 스테이지에 도달한 플레이어 수 = 현재 스테이지 번호보다 큰 숫자의 개수
        for (int i = 1; i <= N; i++) {
            int challengers = 0;            //스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수 = 현재 스테이지 번호와 같은 숫자의 개수
            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j]) {   //현재 스테이지와 같으면 클리어못한 플레이어수 추가
                    challengers++;
                }
            }

            failRate[i - 1][0] = i; //스테이지 번호
            //실패율
            if (totalPlayers == 0) {    //totalPlayers가 0이면 실패율 0.0
                failRate[i-1][1] = 0.0;
            } else {
                failRate[i - 1][1] = (double) challengers / (double) totalPlayers;
            }
            totalPlayers -= challengers;
        }


        Arrays.sort(failRate, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[1] == o2[1]) {   //실패율이 같다면 스테이지번호 기준으로 오름차순 정렬
                    return Double.compare(o1[0], o2[0]);
                } else {                //실패율 기준으로 내림차순 정렬
                    return Double.compare(o2[1], o1[1]);
                }
            }
        });

        //스테이지 번호만 result 배열에 저장
        for (int i = 0; i < failRate.length; i++) {
            result[i] = (int) failRate[i][0];
        }

        return result;
    }
}



public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();

        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//        int[] stages = {4, 4, 4, 4, 4};
        int[] solution1 = solution.solution(5, stages);

        for (int i : solution1) {
            System.out.print(i + " ");
        }
    }
}
