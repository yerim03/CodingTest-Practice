import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static Stack<Integer> stack = new Stack<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == 1) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            } else {
                stack(num);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void stack(int num) {
        switch (num) {
            case 2: {
                if (!stack.isEmpty()) sb.append(stack.pop() + "\n");
                else sb.append(-1 + "\n");
                break;
            }
            case 3: {
                sb.append(stack.size() + "\n");
                break;
            }
            case 4: {
                if (stack.isEmpty()) sb.append(1 + "\n");
                else sb.append(0 + "\n");
                break;
            }
            case 5: {
                if (!stack.isEmpty()) sb.append(stack.peek() + "\n");
                else sb.append(-1 + "\n");
                break;
            }
        }
    }
}
