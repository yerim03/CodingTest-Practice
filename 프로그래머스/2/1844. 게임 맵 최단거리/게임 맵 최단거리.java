//상대팀 진영에 도착하기 위해 지나가야 하는 칸 개수의 최솟값
//도착할 수 없을 경우 -1

//벽이 0, 길이 1

import java.util.*;

class Solution {
    
    class Pair {
        int x;
        int y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = bfs(0, 0, maps);
        return answer;
    }
    
    public int bfs(int x, int y, int[][] maps) {
        int n = maps.length;    //열의 크기
        int m = maps[0].length; //행의 크기

        Queue<Pair> q = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        q.add(new Pair(x, y));
        
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            x = p.x;
            y = p.y;
            
            if(x == n - 1 && y == m - 1)    return maps[x][y];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
            
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                     continue;
                }
                if(maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }
        return -1;
    }
}