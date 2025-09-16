import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> path = new ArrayList<>();
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        answer = new String[tickets.length + 1];
        //출발 공항명 알파벳 순으로 정렬
        Arrays.sort(tickets, (str1, str2) -> {
            return str1[0].equals(str2[0]) ? str1[1].compareTo(str2[1]) : str1[0].compareTo(str2[0]);
        });

        dfs("ICN", tickets);
        
        return answer;
    }
    
    public void dfs(String departure, String[][] tickets) {
        path.add(departure);
        
        if(answer[0] != null) return;   //이미 경로를 찾은 경우(answer에 값이 들어있음)
        
        if(path.size() == tickets.length + 1) {
            for(int i = 0; i < answer.length; i++) {
            answer[i] = path.get(i);
            }
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(departure)) {
                visited[i] = true;
                dfs(tickets[i][1], tickets);
                path.remove(path.size() - 1);
                visited[i] = false;
            }   
        }
    }  
}