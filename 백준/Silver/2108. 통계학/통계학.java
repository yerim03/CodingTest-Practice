import java.io.*;
import java.util.*;

/**
 * S2 2108 통계학
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array); //오름차순 정렬

        double sum = 0.0;
        Map<Integer, Integer> map = new HashMap<>();    //최빈값
        for (int i : array) {
            sum += i;
            //최빈값 계산을 위해 각 숫자의 개수 구하기
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        double average = sum < 0 ? Math.round(sum / n) : -(Math.round(-(sum) / n));
        sb.append((int)average + "\n");  //평균


        sb.append(array[array.length / 2] + "\n"); //중앙값


        int mostValue = Collections.max(map.values());
        ArrayList<Integer> keys = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == mostValue) {
                keys.add(key);
            }
        }

        if (keys.size() == 1) { //최빈값이 한 개일 경우
            sb.append(keys.get(0) + "\n");
        } else {    //최빈값이 여러 개일 경우
            Collections.sort(keys);
            sb.append(keys.get(1) + "\n");
        }


        sb.append(array[n - 1] - array[0] + "\n");  //범위
        System.out.println(sb);
    }
}