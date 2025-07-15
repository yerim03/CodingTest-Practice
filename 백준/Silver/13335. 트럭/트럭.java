import java.io.*;
import java.util.*;

/**
 * S1 13335 트럭
 */


public class Main {
    
    static int[] distance;
    static ArrayList<Integer> onBridgeIdx = new ArrayList<>(); //다리 위 트럭들의 번호
    static int onBridgeW = 0;  //다리 위 트럭들의 무게 합
     
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //트럭의 수
        int w = sc.nextInt();   //다리의 길이
        int l = sc.nextInt();   //다리의 최대하중

        int[] truck = new int[n];
        distance = new int[n];    //각 트럭이 다리를 모두 건넜는지 길이를 나타내는 배열
        for (int i = 0; i < n; i++) {
            truck[i] = sc.nextInt();
        }

        int result = 0; //최단시간
        int idx = 0;    //트럭 번호

        while(true) {
            //모든 트럭이 다 건넌 경우 종료
            if (idx == n) {
                break;
            }

            if (onBridgeW + truck[idx] <= l) {  //l보다 작거나 같으면 idx번 트럭도 다리로 이동
                onBridgeW += truck[idx];
                onBridgeIdx.add(idx);
                move();
                
                idx++;
            } else {    //l보다 크면 다리 위에 있는 트럭트면 한 칸씩 이동
                for (int i = 0; i < onBridgeIdx.size(); i++) {
                    distance[onBridgeIdx.get(i)]++;
                }
            }
            result++;   //이동시간 증가

            int frontTdx = onBridgeIdx.get(0); //다리의 맨 앞에 있는 트럭번호
            if (distance[frontTdx] == w) {  //해당 트럭이 다리를 모두 건넌 경우
                onBridgeIdx.remove(0);
                onBridgeW -= truck[frontTdx];
            }

        }
        result += w - distance[n-1] + 1;//마지막 트럭이 건너오는 시간까지 더한다.
        System.out.println(result);
    }

    public static void move() {
        for (int i = 0; i < onBridgeIdx.size(); i++) {
            distance[onBridgeIdx.get(i)]++;
        }
    }
}