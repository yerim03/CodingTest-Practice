import java.io.*;
import java.util.*;

/**
 * S3 20291 파일 정리
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            String str = st.nextToken();
            String str1 = st.nextToken();

            if (map.containsKey(str1)) {
                map.put(str1, map.get(str1) + 1);
            } else {
                map.put(str1, 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());    //keySet을 리스트로
        Collections.sort(keySet);   //key 오름차순 정렬

        for (String key : keySet) {
            System.out.println(key + " " + map.get(key));
        }
    }
}