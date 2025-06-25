import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        String regex = "[ABCDEF]?A+F+C+[ABCDEF]?";
        while (t > 0) {
            String str = br.readLine();
            if (str.matches(regex)) {
                System.out.println("Infected!");
            } else {
                System.out.println("Good");
            }
            t--;
        }
    }
}