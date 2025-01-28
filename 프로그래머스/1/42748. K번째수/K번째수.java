import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int x = 0; x < commands.length; x++) {
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];

            ArrayList<Integer> list = new ArrayList<>();    //자른 숫자를 담을 리스트
            //i번째부터 j번째 까지의 숫자 자르기
            for (int y = i - 1; y < j; y++) {
                list.add(array[y]);
            }
            Collections.sort(list); //자른 숫자들을 정렬
            answer[x] = list.get(k-1);  //k번째 숫자를 골라서 정답 배열에 담는다.
        }
        return answer;
    }
}