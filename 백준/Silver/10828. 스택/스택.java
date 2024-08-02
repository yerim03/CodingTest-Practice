import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if (order.equals("pop")) {
                if (!stack.empty()) {
                    bw.write(stack.pop() + "\n");
                } else {
                    bw.write("-1" + "\n");
                }
            } else if (order.equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (order.equals("empty")) {
                if (!stack.isEmpty()) {
                    bw.write("0" + "\n");  //비어있지 않으면 0
                } else {
                    bw.write("1" + "\n");  //비어있으면 1
                }
            } else if (order.equals("top")) {
                if (!stack.empty()) {
                    bw.write(stack.peek() + "\n");
                } else {
                    bw.write("-1" + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}