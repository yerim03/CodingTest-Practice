import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    //연산의 개수

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) { //절대값이 같으면 더 작은 값을 앞으로 보내준다.
                    return o1 - o2;
                } else {
                    return Math.abs(o1) - Math.abs(o2);}

            }
        });


        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {    //큐에서 절대값이 가장 작은 값 출력 후 제거
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {    //큐에 x 추가
                pq.offer(x);
            }
        }
    }
}