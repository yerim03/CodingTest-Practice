import java.io.*;

/**
 * S3 15886 내 선물을 받아줘2
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    //골목길의 길이
        String str = br.readLine();

        int result = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("EW")) {
                result++;
            }
        }
        System.out.println(result);
    }
}