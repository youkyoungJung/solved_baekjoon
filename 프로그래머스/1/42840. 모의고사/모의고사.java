import java.util.*;

class Solution {
    
    int[] supo1 = {1, 2, 3, 4, 5};
    int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] supo3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        
        int[] res = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            //supo1 비교
            if(answers[i] == supo1[i%5]){
                res[0]++;
            }
            //supo2 비교
            if(answers[i] == supo2[i%8]){
                res[1]++;
            }
            //supo3 비교
            if(answers[i] == supo3[i%10]){
                res[2]++;
            }
             
        }
        
        // System.out.println(Arrays.toString(res));
        int max = Math.max(res[0], Math.max(res[1], res[2]));

        ArrayList<Integer> score = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++){
            if(max == res[i]){
                score.add(i+1);
            }
        }
        
        int[] answer = new int[score.size()];
        for(int i = 0; i < score.size(); i++){
            answer[i] = score.get(i);
        }
        
        return answer;
    }
}