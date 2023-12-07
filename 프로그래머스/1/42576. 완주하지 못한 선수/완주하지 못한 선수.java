import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < participant.length; i++){
            if(!map.containsKey(participant[i])){
                map.put(participant[i], 1);
            }else{
                map.put(participant[i], map.get(participant[i])+1);
            }   
        }
      
       for(int i = 0; i < completion.length; i++){
           if(map.containsKey(completion[i])){
               map.put(completion[i], map.get(completion[i])-1);
           }
       }
       String answer = "";
    
        for(int i = 0; i < map.size(); i++){
            if(map.get(participant[i]) == 1){
                answer = participant[i];
            }
        }
        
       
        return answer;
    }
}