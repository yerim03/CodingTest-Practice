import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[][] failRate = new double[N][2];
        int[] result = new int[N];

        int totalPlayers = stages.length;     //현재 스테이지에 도달한 플레이어 수 = 현재 스테이지 번호보다 큰 숫자의 개수
        for (int i = 1; i <= N; i++) {
            int challengers = 0;            //스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수 = 현재 스테이지 번호와 같은 숫자의 개수
            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j]) {   //현재 스테이지와 같으면
                    challengers++;
                }
            }
            failRate[i - 1][0] = i;

            if (totalPlayers == 0) {
                failRate[i-1][1] = 0.0;
            } else {
                failRate[i - 1][1] = (double) challengers / (double) totalPlayers;
            }
            totalPlayers -= challengers;
        }


        Arrays.sort(failRate, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[1] == o2[1]) {   //실패율이 같다면 스테이지번호 오름차순
                    return Double.compare(o1[0], o2[0]);
                } else {                //실패율 내림차순 정렬
                    return Double.compare(o2[1], o1[1]);
                }
            }
        });

        for (int i = 0; i < failRate.length; i++) {
            result[i] = (int) failRate[i][0];
        }

        return result;
    }
}