package dynamicProgramming._1로만들기;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int[] d = new int[x + 1];   //계산 결과를 저장하기 위한 DP 테이블

        for (int i = 2; i <= x; i++) {
            d[i] = d[i - 1] + 1;    //1을 빼는 경우

            if (i % 2 == 0) {       //2로 나누어 떨어지는 경우
                d[i] = Math.min(d[i], d[i / 2] + 1);

            }
            if (i % 3 == 0) {       //3으로 나누어 떨어지는 경우
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            if (i % 5 == 0) {       //5로 나누어 떨어지는 경우
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }
        }

        System.out.println(d[x]);
    }
}
