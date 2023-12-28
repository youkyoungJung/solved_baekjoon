import java.util.*;

class Solution {
    
    String[] words = {"A", "E", "I", "O", "U"};
    List<String> list;
    
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<String>();
        
        dfs("", 0);
        
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public void dfs(String str, int cnt){
        list.add(str);
        //기저조건
        if(cnt == 5){
            return;
        }
        
        for(int i = 0; i < 5; i++){
            dfs(str+words[i], cnt+1);
        }
    }
}