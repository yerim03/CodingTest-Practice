import java.io.*;
import java.util.*;

/**
 * G4 17298 오큰수
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        int[] nge = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                nge[stack.peek()] = numbers[i];
                stack.pop();
            }
            stack.push(i);  //현재 숫자의 인덱스 push
        }

        //오큰수가 없는 경우
        while (!stack.isEmpty()) {
            nge[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int s : nge) {
            sb.append(s + " ");
        }

        System.out.println(sb);
    }
}
