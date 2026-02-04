class Solution {
    public long solution(int n) {
        
        if(n <= 2) return n;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        
        return dp[n];
    }
}
    
    
/*
    static long answer = 0;
    public long solution(int n) {
        dfs(0, n);
        
        return (answer % (long)1234567);
    }
    
    public void dfs(int sum, int n) {
        if(sum >= n) {
            if(sum == n)    answer++;
            return;
        }
        
        dfs(sum + 1, n);
        dfs(sum + 2, n);
    }
    
*/
