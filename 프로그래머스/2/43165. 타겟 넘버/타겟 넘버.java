
class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(0, numbers.length, 0, target, numbers);
        return answer;
    }
    
    public void dfs(int cur, int end, int result, int target, int[] numbers) {
        if(cur == end) {
            if(result == target) {
                answer++;
            }
            return;
        }
        
        dfs(cur + 1, end, result + numbers[cur], target, numbers);
        dfs(cur + 1, end, result - numbers[cur], target, numbers);
    }
}