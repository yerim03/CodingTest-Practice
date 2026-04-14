import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t > 0) {
            String str = br.readLine();
            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();

            //현재 커서의 위치는 leftStack과 rightStack의 사이

            for (int i = 0; i < str.length(); i++) {
                char cmd = str.charAt(i);

                switch (cmd) {
                    case '<' : {   //왼쪽 이동
                        if(!leftStack.isEmpty()) rightStack.add(leftStack.pop());
                        break;
                    }
                    case '>' : {   //오른쪽 이동
                        if(!rightStack.isEmpty()) leftStack.add(rightStack.pop());
                        break;
                    }
                    case '-' : {   //백스페이스
                        if(!leftStack.isEmpty()) leftStack.pop();
                        break;
                    }
                    default : {
                        leftStack.push(cmd);
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();

            //왼쪽 스택
            for (Character ch : leftStack) {
                sb.append(ch);
            }

            //오른쪽 스택
            while(!rightStack.isEmpty()) {
                sb.append(rightStack.pop());
            }
            System.out.println(sb);
            t--;
        }
    }
}