//0-벽, 1-벽X
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                //맵 범위를 벗어나는 경우
                if(nx < 0 || ny < 0 || nx >= n || ny >= m)  continue;
                //벽때문에 지나갈 수 없는 경우
                if(maps[nx][ny] != 1)   continue;
                
                maps[nx][ny] = maps[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        return (maps[n - 1][m - 1] == 1) ? -1 : maps[n - 1][m - 1];
    }
}