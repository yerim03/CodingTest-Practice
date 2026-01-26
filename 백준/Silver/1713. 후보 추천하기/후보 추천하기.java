import java.io.*;
import java.util.*;

/**
 * S1 1713 후보 추천하기
 * https://www.acmicpc.net/problem/1713
 * */


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();

        int n = Integer.parseInt(br.readLine());    //사진틀의 개수
        int m = Integer.parseInt(br.readLine());    //전체 학생 추천 횟수

        int[] students = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < students.length; i++) {
            if(hm.size() == n && !hm.containsKey(students[i])) {
                int minKey = 0;
                int minValue = 1001;
                //현재까지 추천횟수가 가장 적은 학생 탐색
                for(Integer key : hm.keySet()) {
                    if (minValue > hm.get(key)) {
                        minValue = hm.get(key);
                        minKey = key;
                    }
                }
                hm.remove(minKey);  //추천횟수가 가장 적은 학생 삭제
            }

            hm.put(students[i], hm.getOrDefault(students[i], 0) + 1);
        }

        Object[] array = hm.keySet().toArray();
        Arrays.sort(array);

        for (Object o : array) {
            System.out.print(o + " ");
        }
    }
}