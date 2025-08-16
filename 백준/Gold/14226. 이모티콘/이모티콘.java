import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * G4 14226 이모티콘
 */
/*
* 화면에 있는 1개의 이모티콘을 3가지 연산만을 사용해서 S 개로 만든다
* 1. 화면에 있는 이모티콘 모두 복사해서 클립보드에 저장
* 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
* 3. 화면에 있는 이모티콘 중 하나 삭제
* 각 연산을 수행하는데 걸리는 시간은 1초
* 클립보드에 복사 시, 이전에 클립보드에 있던 내용은 덮어쓰기
* 클립보드가 비어있으면 화면에 붙여넣기 X,
* 일부만 클립보드에 복사 X,
* 클립보드에 있는 이모티콘 중 일부 삭제 X
* */

class Emoticon {
    int clip;
    int screen;
    int cnt;

    public Emoticon(int clip, int screen, int cnt) {
        this.clip = clip;
        this.screen = screen;
        this.cnt = cnt;
    }
}

public class Main {

    static int s;
    static boolean[][] visited = new boolean[1001][1001];   //[clip][screen]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = Integer.parseInt(br.readLine());

        int result = bfs();
        System.out.println(result);
    }


    public static int bfs() {
        Queue<Emoticon> q = new LinkedList<>();
        q.offer(new Emoticon(0, 1, 0));

        while (!q.isEmpty()) {
            Emoticon emo = q.poll();
            int clip = emo.clip;
            int screen = emo.screen;
            int cnt = emo.cnt;

            //종료조건
            if (screen == s) {
                return cnt;
            }

            //화면 -> 클립보드 복사
            if(!visited[screen][screen]) {
                q.offer(new Emoticon(screen, screen, cnt + 1));
                visited[screen][screen] = true;
            }
            //클립보드 -> 화면 붙여넣기
            if (clip >= 1 &&  screen + clip <= 1000 && !visited[clip][screen + clip]) {
                q.offer(new Emoticon(clip, screen + clip, cnt + 1));
                visited[clip][screen + clip] = true;
            }

            //화면에 있는 이모티콘 하나 삭제
            if (screen >= 1 && !visited[clip][screen - 1]) {
                q.offer(new Emoticon(clip, screen - 1, cnt + 1));
                visited[clip][screen - 1] = true;
            }
        }
        return 0;
    }
}