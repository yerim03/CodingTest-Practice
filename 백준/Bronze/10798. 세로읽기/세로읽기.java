import java.io.*;

public class Main {

     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

         String[][] array = new String[5][15];

         for (int i = 0; i < 5; i++) {
             String str = br.readLine();
             for (int j = 0; j < str.length(); j++) {
                 array[i][j] = String.valueOf(str.charAt(j));
             }
         }

         for (int i = 0; i < 15; i++) {
             for (int j = 0; j < 5; j++) {
                 if (array[j][i] != null) {
                     bw.write(array[j][i]);
                 }
             }
         }

         bw.flush();
         bw.close();
    }
}