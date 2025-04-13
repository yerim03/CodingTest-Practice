package dynamicProgramming.fibo;

//Bottom-Up
public class Main3 {

    public static long[] d = new long[100];

    public static void main(String[] args) {
        d[1] = 1;
        d[2] = 1;
        int n = 50;

        //Bottom-Up 다이나믹 프로그래밍 - 반복문 사용
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        System.out.println(d[n]);
    }
}
