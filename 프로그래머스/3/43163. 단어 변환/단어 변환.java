class Solution {
    
    static boolean[] visited;
    static int answer = 51;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        boolean flag = false;
        
        //words에 target이 존재하는지 확인
        for(int i = 0; i < words.length; i++) {
            if(target.equals(words[i])) {
                flag = true;
            }  
        }
        
        if(flag) {
            dfs(words, begin, target, 0);
        } else {
            answer = 0;
        }
        
        return answer;
    }
    
    /**
    @param current 현재 단어
    @param cnt 변환 횟수
    */
    public void dfs(String[] words, String current, String target, int cnt) {
        //종료조건
        if(current.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(!visited[i]) {
                String change = words[i];
                int changeCnt = 0;
                
                //단어 current와 단어 change 비교해서 다른 문자의 갯수 확인
                for(int j = 0; j < current.length(); j++) {
                    if(current.charAt(j) != change.charAt(j)) {
                        changeCnt++;
                    }
                }
                
                //하나의 알파벳만 다를 경우 change로 변환 가능
                if(changeCnt == 1) {
                    visited[i] = true;
                    dfs(words, change, target, cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
}