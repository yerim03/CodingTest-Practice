class Solution {
    int answer = 0;
    boolean[] issued1;
    boolean[] issued2;
    boolean[] issued3;
    
    public int solution(int n) {
        
        issued1 = new boolean[n];   
        issued2 = new boolean[n * 2 - 1];
        issued3 = new boolean[n * 2 - 1];

        backtracking(0, n);
        return answer;
    }
    
    public void backtracking(int cnt, int n) {
        //종료조건
        if(cnt == n) {
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            //issued1, issued2, issued3에서 하나라도 true이면 continue
            if(issued1[i] || issued2[cnt + i] || issued3[cnt - i + n - 1]) {
                continue;
            }
            
            issued1[i] = true;
            issued2[cnt + i] = true;
            issued3[cnt - i + n - 1] = true;
            backtracking(cnt + 1, n);
            issued1[i] = false;
            issued2[cnt + i] = false;
            issued3[cnt - i + n - 1] = false;                 
        }

    }

}