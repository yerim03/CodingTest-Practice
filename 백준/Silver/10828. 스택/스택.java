import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        while (n > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push": {
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                }
                case "pop": {
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;
                }
                case "size": {
                    System.out.println(stack.size());
                    break;
                }
                case "empty": {
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                }
                case "top": {
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;
                }
            }
            n--;
        }
    }
}