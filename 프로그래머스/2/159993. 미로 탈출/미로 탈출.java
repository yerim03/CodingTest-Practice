import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    
    static int n, m;
    static char[][] map;
    static class Node {
        int x;
        int y;
        int dist;
        
        Node (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        
        // S, L, E의 위치 찾기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                char ch = maps[i].charAt(j);
                if (ch == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (ch == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (ch == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
                map[i][j] = ch;
            }
        }
        
        int a = bfs(start, lever);  //start -> lever
        int b = bfs(lever, end);    //lever -> end
        
        if(a == -1 || b == -1) {
            return -1;
        } else {
            return a + b;
        }
    }
    
    public int bfs(int[] start, int[] end) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
    
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        q.offer(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()) {
            Node poll = q.poll();
            int x = poll.x;
            int y = poll.y;
            int dist = poll.dist;
            
            if(x == end[0] && y == end[1]) {
                return dist;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                //미로의 범위를 벗어나는 경우
                if(nx < 0 || ny < 0 || nx >= n || ny >= m)  continue;
                //이미 방문했거나 벽인 경우
                if(visited[nx][ny] || map[nx][ny] == 'X')  continue;
                
                q.offer(new Node(nx, ny, dist + 1));
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
}