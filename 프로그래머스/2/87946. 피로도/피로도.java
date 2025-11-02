import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        
        return max;
        
    }

    public void dfs(int k, int cnt, int[][] dungeons) {
        max = Math.max(max, cnt);
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], cnt + 1, dungeons);
                visited[i] = false;
            }
        }
        
        
    }
}