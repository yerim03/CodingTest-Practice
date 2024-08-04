package greedy.거스름돈;

public class Main {
    public static void main(String[] args) {
        int n = 1260;   //거스름 돈
        int[] coin_types = {500, 100, 50, 10};

        int count =0;
        for (int coin : coin_types) {
            count += (n / coin);
            n %= coin;
        }
        System.out.println(count);
    }
}
