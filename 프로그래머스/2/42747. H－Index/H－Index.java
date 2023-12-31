import java.util.*;

class Solution {
    int len;
    int answer = 0;
    public int solution(int[] citations) {
        
        len = citations.length;
        Arrays.sort(citations);
        // System.out.println(Arrays.toString(citations));
        for(int i = 0; i < len; i++){
            int h = len - i; //논문의 개수

            if(h <= citations[i]){ //논문의 개수 <= 
                 answer = h;
                 break;
            } 
        }
        
        return answer;
    }
    
    //0 1 3 5 6
    //3 len = 5 h = 3, 3
    //1 len = 5 h = 1, 4

    
    
}