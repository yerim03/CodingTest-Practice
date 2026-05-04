
class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(0, 0, target, numbers);
        return answer;
    }
    
    void dfs(int cur, int result, int target, int[] numbers) {
        if(cur == numbers.length) {
            if(result == target) {
                answer++;
            }
            return;
        }
        
        dfs(cur + 1, result + numbers[cur], target, numbers);
        dfs(cur + 1, result - numbers[cur], target, numbers);
    }
}