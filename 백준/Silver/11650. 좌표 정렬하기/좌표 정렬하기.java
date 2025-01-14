import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] array = new int[n][2];  //점의 좌표
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            array[i][0] = Integer.parseInt(st.nextToken()); //x
            array[i][1] = Integer.parseInt(st.nextToken()); //y
        }

//        Arrays.sort(array, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
//            }
//        });

        Arrays.sort(array, (int[] o1, int[] o2) -> {
                return (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
            }
        );

        for (int i = 0; i < n; i++) {
            bw.write(array[i][0] + " " + array[i][1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}