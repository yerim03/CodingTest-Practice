import java.io.*;
import java.util.*;

/**
 * S1 13335 트럭
 */


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //트럭의 수
        int w = sc.nextInt();   //다리의 길이
        int l = sc.nextInt();   //다리의 최대하중

        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        //truck 큐에 트럭의 무게 삽입
        for (int i = 0; i < n; i++) {
            truck.add(sc.nextInt());
        }

        //bridge 큐에 w개 만큼 0 삽입 - 현재 다리에 올라와 있는 트럭의 위치
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }


        int result = 0; //최단시간
        int onBridgeW = 0;  //다리에 올라와 있는 트럭들 무게의 합

        //다리에 아무것도 존재하지 않을 때까지 수행
        while (!bridge.isEmpty()) {
            result++;

            onBridgeW -= bridge.poll(); //맨 앞의 트럭부터 한 대씩 다리에서 내려온다.
            if(!truck.isEmpty()) {
                if (onBridgeW + truck.peek() <= l) {    //최대하중과 같거나 작을 경우
                    onBridgeW += truck.peek();
                    bridge.add(truck.poll());   //다리에 트럭 올라감
                } else {    //최대하중보다 클 경우
                    bridge.add(0);  //bridge 큐에 0 삽입(트럭이 앞으로 한 칸씩 이동)
                }
            }
        }
        System.out.println(result);
    }
}