import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//암호만들기
public class Main {

    public static int L, C;
    public static String vowels = "aeiou";
    public static String[] array, password;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        array = new String[C];
        password = new String[L];
        //C개의 문자 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            array[i] = st.nextToken();
        }

        Arrays.sort(array); //입력받은 알파벳을 오름차순 정렬
        createPassword(0, 0);
    }

    public static void createPassword(int depth, int start) {
        //종료조건
        //1. 길이가 L
        //2. 모음이 최소 2개
        //3. 자음이 최소 1개
        if (depth == L) {
            int c = 0, v = 0;
            //모음, 자음의 개수 체크
            for (String s : password) {
                if (vowels.contains(s)) {
                    v++;
                } else {
                    c++;
                }
            }

            if (c >= 2 && v >= 1) {
                for (String s : password) {
                    System.out.print(s);
                }
                System.out.println();
            }
            return;
        }

        for (int i = start; i < C; i++) {
            password[depth] = array[i];
            createPassword(depth + 1, i + 1);
        }
    }

}

