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
        stack.push(numbers[n - 1]);  //스택에 가장 마지막 수 push
        nge[n - 1] = -1;    //가장 마지막수의 nge는 항상 -1
        for (int i = n - 2; i >= 0; i--) {
            int cur = numbers[i];   //현재 숫자

            if(cur < stack.peek()) {    //stack의 top이 더 클 경우
                nge[i] = stack.peek();
            } else {
                while(!stack.isEmpty() && cur >= stack.peek()) {
                    stack.pop();
                }
                if(!stack.isEmpty()) nge[i] = stack.peek();
                else    nge[i] = -1;
            }
            stack.push(cur);
        }

        StringBuilder sb = new StringBuilder();
        for(int s : nge) {
            sb.append(s + " ");
        }

        System.out.println(sb);
    }
}
