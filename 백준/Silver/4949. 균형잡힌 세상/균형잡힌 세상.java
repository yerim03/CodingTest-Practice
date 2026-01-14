import java.io.*;
import java.util.*;

/**
 * S4 4949 균형잡힌 세상
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();

            if(str.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if(ch == '(' || ch == '[') {
                    stack.push(ch);
                }

                if(ch == ')' || ch == ']') {
                    if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            }

            if(stack.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.println(sb);
    }
}
