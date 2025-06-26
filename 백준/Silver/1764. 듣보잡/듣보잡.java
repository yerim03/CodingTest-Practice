import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   //듣도 못한 사람 수
        int m = Integer.parseInt(st.nextToken());   //보도 못한 사람 수

        HashSet<String> set = new HashSet<>();
        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int j = 0; j < m; j++) {
            String noSee = br.readLine();
            if (set.contains(noSee)) {
                resultList.add(noSee);
            }
        }

        Collections.sort(resultList);
        System.out.println(resultList.size());
        for (String s : resultList) {
            System.out.println(s);
        }
    }
}