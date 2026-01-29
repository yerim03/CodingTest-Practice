import java.io.*;

/**
 * G5 7490 0만들기
 *https://www.acmicpc.net/problem/7490
 * */

public class Main {

    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t > 0) {
            n = Integer.parseInt(br.readLine());
            dfs(1, "1");
            sb.append("\n");
            t--;
        }
        System.out.println(sb);
    }

    public static void dfs(int num, String str) {
        if(num == n) {
            if(calculate(str) == 0) {   //수식을 계산에서 값이 0이면 sb에 추가
                sb.append(str + " \n");
            }
            return;
        }

        dfs(num + 1, str + " " + (num+1));
        dfs(num + 1, str + "+" + (num+1));
        dfs(num + 1, str + "-" + (num+1));
    }

    public static int calculate(String str) {
        String express = str.replace(" ", "");  //숫자와 숫자 사이 공백 제거

        /* +. - 앞뒤로 공백 한 칸씩을 추가한 후, " "(공백)을 기준으로 문자열을 쪼갠다.
          1+2-3 -> 1 + 2 - 3 -> {"1", "+", "2", "-", "3"}
        */
        String express1 = express.replace("+",  " + ").replace("-", " - ");
        String[] strings = express1.split(" ");

        int sum = Integer.parseInt(strings[0]);
        for(int i = 1; i < strings.length; i += 2) {
            if(strings[i].equals("+")) {
                sum += Integer.parseInt(strings[i + 1]);
            } else if (strings[i].equals("-")) {
                sum -= Integer.parseInt(strings[i + 1]);
            }
        }
        return sum;
    }
}