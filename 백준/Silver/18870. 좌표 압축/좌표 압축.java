import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] array_sort = array.clone();
        Arrays.sort(array_sort);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i : array_sort) {
            if (!map.containsKey(i)) {
                map.put(i, rank);
                rank++;
            }
        }


        for (int i : array) {
            bw.write(map.get(i) + " ");
        }

        bw.flush();
        bw.close();
    }
}