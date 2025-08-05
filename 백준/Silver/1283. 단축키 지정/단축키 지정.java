import java.io.*;

/**
 * S1 1283 단축키 지정
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        boolean[] alpha = new boolean[26];
        boolean flag;

        while (n > 0) {
            String str = br.readLine();
            String[] words = str.split(" ");

            flag = false;
            //옵션의 각 단어의 첫 글자가 단축키로 지정될 수 있는지 탐색
            for (int i = 0; i < words.length; i++) {
                String lowerWord = words[i].toLowerCase();
                int first = lowerWord.charAt(0) - 'a';
                if (!alpha[first]) {    //첫 번째 글자로 단축키를 지정할 수 있는 경우
                    words[i] = "[" + words[i].charAt(0) + "]" + words[i].substring(1, words[i].length());
                    alpha[first] = true;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                for (String word : words) {
                    sb.append(word + " ");
                }
                sb.append("\n");
                } else {//첫 번째 글자로 단축키를 지정할 수 없는 경우
                String lowerStr = str.toLowerCase();
                for (int i = 0; i < lowerStr.length(); i++) {
                    int w = lowerStr.charAt(i)- 'a';
                    if (w >= 0 && !alpha[w]) {
                        str = str.substring(0, i) + "[" + str.charAt(i) + "]" + str.substring(i + 1, str.length());
                        sb.append(str + "\n");
                        alpha[w] = true;
                        flag = true;
                        break;
                    }
                }
            }

            //어떠한 것도 단축키로 지정할 수 없는 경우
            if (!flag) {
                sb.append(str + "\n");
            }
            n--;
        }

        System.out.println(sb);
    }
}