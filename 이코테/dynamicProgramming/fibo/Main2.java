package dynamicProgramming.fibo;

//Top-Down
public class Main2 {

    //한 번 계산된 결과를 메모이제이션하기 위한 배열
    public static long[] d = new long[100];

    //Top-Down 다이나믹 프로그래밍 - 재귀함수 사용
    public static long fibo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }

        //이미 계산한 적 있는 문제라면 그대로 반환
        if (d[x] != 0) {
            return d[x];
        }
        d[x] = fibo(x - 1) + fibo(x - 2);

        return d[x];
    }

    public static void main(String[] args) {
        System.out.println(fibo(50));
    }
}
