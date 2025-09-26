import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0, 0};
        
        for(int i = 0; i < answers.length; i++) {
            int idx1 = i % student1.length;
            int idx2 = i % student2.length;
            int idx3 = i % student3.length;
            
            if(answers[i] == student1[idx1])    score[0]++;  
            if(answers[i] == student2[idx2])   score[1]++;
            if(answers[i] == student3[idx3])   score[2]++;
        }
        
        for(int i = 0; i < 3; i++) {
            System.out.print(score[i] + " ");
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> ansList = new ArrayList<>();
        for(int i = 0; i < score.length; i++) {
            if(max == score[i]) {
                ansList.add(i + 1);
            }
        }
        int[] answer = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++) {
             answer[i] = ansList.get(i);
        }
        return answer;
    }
}