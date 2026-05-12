//최소 필요 피로도 - 탐험을 하기 위한 최소한의 피로도
//소모 피로도 - 탐험 후 소모되는 피로도
//유저가 탐험할 수 있는 최대 던전 수
class Solution {
    
    int answer = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        return answer;
    }
    
    public void dfs(int cur, int cnt, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && cur >= dungeons[i][0]) {
                visited[i] = true;
                dfs(cur - dungeons[i][1], cnt + 1, dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, cnt);
    }
}