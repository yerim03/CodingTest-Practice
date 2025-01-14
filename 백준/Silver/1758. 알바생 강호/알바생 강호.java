import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //팁: 원래주려던 돈 - (받은 등수 - 1)
        //손님 순서를 적절히 바꿔서 최대로 받을 수 있는 팁 구하기

        int n = Integer.parseInt(br.readLine());    //손님 수
        Integer[] array = new Integer[n];   //팁

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array, Collections.reverseOrder()); //내림차순 정렬

        long max_tips = 0;
        for (int i = 0; i < n; i++) {
            if(array[i] - i < 0){    //음수이면 팁을 주지 않는다.
                break;
            }
            max_tips += (array[i] - i);
        }

        bw.write(max_tips + "\n");
        bw.flush();
        bw.close();
    }
}